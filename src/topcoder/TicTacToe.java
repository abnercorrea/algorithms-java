package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TicTacToe {

	public enum State { ACTIVE, USER_WON, AI_WON, DRAW };

	private static final int BOARD_SIZE = 9;
	private static final int AREA_COUNT = 8;
	private static final char O = 'O';
	private static final char X = 'X';
	
	private char board[];
	private Area areas[];
	private Set<Integer> possibleMoves;
	State state;
	

	/**
	 * 
	 */
	public TicTacToe() {
		areas = new Area[AREA_COUNT];
		
		possibleMoves = new HashSet<Integer>(9);
		
		board = new char[BOARD_SIZE];
	}
	
	
	public static void main(String[] args) {
		boolean userStarts = readUserStarts();
		char userSymbol = readUserSymbol();
		
		TicTacToe ticTacToe = new TicTacToe();
		
		State result = ticTacToe.play(userSymbol, userStarts);

		displayGameResult(result);
	}

	/**
	 * @param userSymbol
	 * @param userStarts
	 * @return 1 = User won, 2 = AI won, 3 = Draw
	 */
	public State play(char userSymbol, boolean userStarts) {
		boolean isUserTurn = userStarts;
		char aiSymbol = (userSymbol == X) ? O : X;	
		int move = -1;

		initializeGame();
				
		do {
			move = nextMove(isUserTurn);

			evaluateMove(move, isUserTurn);
			
			updateBoard(move, (isUserTurn) ? userSymbol : aiSymbol);
			
			isUserTurn = !isUserTurn;
		}
		while (state == State.ACTIVE);
		
		drawBoard();
		
		return state;
	}

	/**
	 * 
	 */
	private void initializeGame() {
		state = State.ACTIVE; 
		
		// Lines
		areas[0] = new Area(Arrays.asList(0, 1, 2));
		areas[1] = new Area(Arrays.asList(3, 4, 5));
		areas[2] = new Area(Arrays.asList(6, 7, 8));
		// Columns
		areas[3] = new Area(Arrays.asList(0, 3, 6));
		areas[4] = new Area(Arrays.asList(1, 4, 7));
		areas[5] = new Area(Arrays.asList(2, 5, 8));
		// Diagonals
		areas[6] = new Area(Arrays.asList(0, 4, 8));
		areas[7] = new Area(Arrays.asList(2, 4, 6));	
		
		// adds all possible moves.
		possibleMoves.addAll(Arrays.asList(0, 1, 2, 3, 4, 5 ,6 ,7 ,8)); 
	
		initializeBoard();
	}


	/**
	 * @param isUserTurn
	 * @return
	 */
	private int nextMove(boolean isUserTurn) {
		int move = -1;
		
		if (possibleMoves.size() == 1) {
			move = possibleMoves.iterator().next(); // if only 1 possible move left, no need to do anything.
		}
		else {
			if (isUserTurn) {
				drawBoard();

				do {
					move = readUserMove();
				}
				while (!possibleMoves.contains(move));
			}
			else {
				move = calculateAIMove();
			}
		}
		
		// Removes move from possible moves set.
		possibleMoves.remove(move);

		return move;
	}


	/**
	 * @return
	 */
	private int calculateAIMove() {
		int defenseMove = -1;
		List<Integer> defendNextTurnDefeatMove = new ArrayList<>();
		int nextTurnWinMove = -1;
		Set<Integer> setupAreas = new HashSet<>();
		int startAttackMove = -1;
		int maxStartAttackAreas = 0;
		
		for (int possibleMove : possibleMoves) {
			int startAttackAreas = 0; 
			boolean firstSetupMoveFound = false; // used to identify a move that guarantees next turn win.
			boolean firstDefenseMoveFound = false; // used to identify a move that would allow the user to setup a next turn win.
			
			for (int area = 0; area < AREA_COUNT; area++) {
				if (areas[area].slots.contains(possibleMove)) { 				
					if (areas[area].aiCount == 2) { 
						System.out.println("Winning move!"); 
						return possibleMove; // winning move, go for it!
					}
					
					if (areas[area].userCount == 0) { // if it's possible to win on the area	
						if (areas[area].aiCount == 1) { // setup or nextTurnWin move
							if (firstSetupMoveFound) {
								nextTurnWinMove = possibleMove;
							}
							else {
								setupAreas.add(area);
								firstSetupMoveFound = true;
							}						
						}
						else { // areas[i].aiCount == 0
							startAttackAreas++; // found an area where an attack can be started
						}
					}
					else if (areas[area].userCount == 1) {
						if (areas[area].aiCount == 0) { 
							if (firstDefenseMoveFound) {
								defendNextTurnDefeatMove.add(possibleMove);
							}
							else {
								firstDefenseMoveFound = true;
							}
						}
					}
					else if (areas[area].userCount == 2) { // area that needs to be defended
						defenseMove = possibleMove; 
					}
				}
			}
			
			// Used to determine the move that will start an attack on the maximum number of areas simultaneously.
			if (startAttackAreas > maxStartAttackAreas) { 
				startAttackMove = possibleMove; 
				maxStartAttackAreas = startAttackAreas;
			}
		}
		
		if (defenseMove != -1) {
			System.out.println("defenseMove!"); 
			return defenseMove; // if there's no winning move, priority is defense
		}
		else if (nextTurnWinMove != -1) {
			System.out.println("nextTurnWinMove!"); 
			return nextTurnWinMove; // when AI doesn't need to defend and there's a move that guarantees win 
		}
		else if (!defendNextTurnDefeatMove.isEmpty()) { 
			// AI is in possible trouble. User has more than 1 move available to guarantee win on next move.
			// Solution is to attack, forcing user to defend and preventing the setup a next turn win.
			
			System.out.println("defendNextTurnDefeatMove! " + defendNextTurnDefeatMove); 
			System.out.println("Setup areas found:  " + setupAreas); 
			
			for (int area : setupAreas) {
				Set<Integer> setupMoves = new HashSet<>(areas[area].slots);
				
				setupMoves.retainAll(defendNextTurnDefeatMove);
				
				switch (setupMoves.size()) {
					case 1:
						System.out.println("Attack is the best defense!!! (close) attacked area " + area);
						return setupMoves.iterator().next();
					case 0:
						System.out.println("Attack is the best defense!!! attacked area " + area);
						return areas[area].slots.iterator().next();
				}
			}
		}
		else if (!setupAreas.isEmpty()) { // move that sets up win on a single area (puts 2 AI symbols on that area)
			System.out.println("setupMove! " + setupAreas); 
			// returns first available slot of the first setup area found.
			return areas[setupAreas.iterator().next()].slots.iterator().next(); 
		}
		else if (startAttackMove != -1) {
			System.out.println("startAttackMove! in " + maxStartAttackAreas + " areas."); 
			return startAttackMove; // starts an attack with a move the affects the most areas on the board.
		}
		
		// no chance to win and no need to defend... probably will end in a draw
		System.out.println("regular move."); 
		return possibleMoves.iterator().next();
	}

	/**
	 * @param move
	 * @param isUserTurn
	 */
	private void evaluateMove(int move, boolean isUserTurn) {
		for (int i = 0; (i < AREA_COUNT) && (state == State.ACTIVE); i++) {
			if (areas[i].slots.contains(move)) {
				if (isUserTurn) {
					if (++areas[i].userCount == 3) { // increments and check for victory
						state = State.USER_WON;
					}
				}
				else {
					if (++areas[i].aiCount == 3) { // increments and check for victory
						state = State.AI_WON;
					}
				}
				
				areas[i].slots.remove(move); // removes position from available slots.
			}
		}
		
		// Check for draw
		if ((state == State.ACTIVE) && possibleMoves.isEmpty()) {
			state = State.DRAW; // Draw
		}
	}

	private void initializeBoard() {
		// clears the board
		for (int i = 0; i < 9; board[i++] = ' ');	
	}

	private void updateBoard(int move, char symbol) {
		board[move] = symbol;
	}

	private int readUserMove() {
		int line = 0;
		int column = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		do {
			try {
				System.out.print("Line: ");
				line = scanner.nextInt();
			}
			catch (Exception e) {
				System.out.println("Invalid entry, try again.");
			}
		}
		while (line == 0);

		do {
			try {
				System.out.print("Column: ");
				column = scanner.nextInt();
			}
			catch (Exception e) {
				System.out.println("Invalid entry, try again.");
			}
		}
		while (column == 0);
		
		scanner.close();
		
		return (int) ((line - 1) * 3 + column -1);
	}

	private void drawBoard() {
		System.out.println(board[0] + "|" + board[1] + "|" + board[2]);
		System.out.println(board[3] + "|" + board[4] + "|" + board[5]);
		System.out.println(board[6] + "|" + board[7] + "|" + board[8]);
		System.out.println();
	}

	private static char readUserSymbol() {
		char symbol = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		do {
			try {
				System.out.print("User symbol (X-O): ");

				symbol = scanner.next().toUpperCase().charAt(0);
			}
			catch (Exception e) {
				System.out.println("Invalid entry, try again.");
			}
		}
		while (symbol != X && symbol != O);
		
		scanner.close();
		
		return symbol;
	}

	private static boolean readUserStarts() {
		String userStarts = null;
		
		Scanner scanner = new Scanner(System.in);
		
		do {
			try {
				System.out.print("Play first (Y-N): ");
				
				userStarts = scanner.next().toUpperCase();				
			}
			catch (Exception e) {
				System.out.println("Invalid entry, try again.");
			}
		}
		while (!("Y".equals(userStarts) || "N".equals(userStarts)));
		
		scanner.close();
		
		return "Y".equals(userStarts);
	}

	private static void displayGameResult(State result) {
		switch (result) {
			case USER_WON:
				System.out.println("Congratulations, you've won!!!");
				break;
			case AI_WON:
				System.out.println("Sorry, you've lost.");
				break;
			case DRAW:
				System.out.println("Draw!");
				break;				
			default:
				System.out.println("Error: unexpected result.");				
		}
	}
	
	private class Area {
		Set<Integer> slots;
		int userCount = 0;
		int aiCount = 0;
		
		public Area(List<Integer> slots) {
			this.slots = new HashSet<>(slots);
		}
	}
}

