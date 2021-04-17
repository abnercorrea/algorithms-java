package topcoder;
import java.util.Arrays;
import java.util.Scanner;


public class BowlingScore {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.next();
		
		scanner.close();
		
		Frame[] frames = parseInput(input);

		int total = 0;
		
		for (int i = 0; i < 10; i++) {
			total += frames[i].ball[0] + frames[i].ball[1];
			
			// Computes extras for strikes and spares.
			if (frames[i].ball[0] == 10) { // Strike
				total += frames[i + 1].ball[0] + frames[i + 1].ball[1];
				
				if (frames[i + 1].ball[0] == 10) { // Strike on next frame too 
					total += frames[i + 2].ball[0];
				}
			}
			else if (frames[i].ball[0] + frames[i].ball[1] == 10) { // spare
				total += frames[i + 1].ball[0]; // adds next ball
			}
			
			System.out.println("Frame " + (i + 1) + ": " + total);
		}
		
		System.out.println("Total is: " + total);
	}

	private static Frame[] parseInput(String input) {
		Frame[] frames = new Frame[12];
		String[] entries = input.split(",");
		
		System.out.println(Arrays.toString(entries));
		
		for (int i = 0, j = 0; i < 10; i++) {
			frames[i] = new Frame();
			frames[i].ball[0] = Integer.valueOf(entries[j++]);
			
			if (frames[i].ball[0] != 10) {
				frames[i].ball[1] = Integer.valueOf(entries[j++]);				
			}

			if (i == 9) {
				if (frames[9].ball[0] + frames[9].ball[1] == 10) { 
					frames[10] = new Frame(); // creates an 11th frame in case of extra ball on 10th frame
					frames[10].ball[0] = Integer.valueOf(entries[j++]);
					
					if (frames[9].ball[0] == 10) { // Strike on 10th frame gives 2 extra balls
						if (frames[10].ball[0] == 10) {
							frames[11] = new Frame(); // creates an 12th frame in case of strike on 11th frame
							frames[11].ball[0] = Integer.valueOf(entries[j++]);
						}
						else {
							frames[10].ball[1] = Integer.valueOf(entries[j++]);
						}
					}
				}
			}
			
			System.out.println("Frame " + (i + 1) + ": " + frames[i].ball[0] + " - " + frames[i].ball[1]);
		}
		
		return frames;
	}

	public static class Frame {
		int[] ball;
		
		public Frame() {
			ball = new int[2];
		}
	}
}
