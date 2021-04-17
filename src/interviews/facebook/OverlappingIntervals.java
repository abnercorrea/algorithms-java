package interviews.facebook;

public class OverlappingIntervals {

	public static void main(String[] args) {
		int interval[][] = new int[][] { {1, 5}, {5, 10}, {0, 100}, {10, 12} };
		
		System.out.println(maxOverlappingIntervals(interval));
	}

	public static int maxOverlappingIntervals(int[][] interval) {
		int n = 0;
		
		for (int i = 0; i < interval.length - 1; i++)
			for (int j = i + 1; j < interval.length; j++)
				if (interval[i][0] <= interval[j][1] && interval[i][1] >= interval[j][0])
					n++;
		
		return n;
	}
}
