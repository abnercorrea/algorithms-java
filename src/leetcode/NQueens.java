package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();

        solveNQueens(n, 0, new int[n], solutions);

        return solutions;
    }

    public void solveNQueens(int n, int row, int[] queenCols, List<List<String>> solutions) {
        // base case
        if (row == n) {
            solutions.add(generateBoard(queenCols));

            return;
        }

        for (int col = 0; col < n; col++) {
            if (checkValidSpot(row, col, queenCols)) {
                queenCols[row] = col;

                solveNQueens(n, row + 1, queenCols, solutions);
            }
        }
    }

    public boolean checkValidSpot(int row, int col, int[] queenCols) {
        for (int r = 0; r < row; r++) {
            if (queenCols[r] == col) return false;

            if (row - r == Math.abs(col - queenCols[r])) return false;
        }

        return true;
    }

    public List<String> generateBoard(int[] solution) {
        List<String> board = new ArrayList<>();

        char[] line = new char[solution.length];

        Arrays.fill(line, '.');

        for (int i = 0; i < solution.length; i++) {
            line[solution[i]] = 'Q';

            board.add(new String(line));

            line[solution[i]] = '.';
        }

        return board;
    }

    public static void main(String args[]) {
        int n = 8;
        List<List<String>> solutions = new NQueens().solveNQueens(n);

        System.out.println(solutions.size());

        solutions.forEach((solution) -> {
            solution.forEach(System.out::println);
            System.out.println();
        });
    }
}