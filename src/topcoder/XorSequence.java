package topcoder;

public class XorSequence {

	public static void main(String[] args) {
		XorSequence xorSequence = new XorSequence();
		
		int[][] input = new int[][] {
			{4,6,3,2,0,1,3},
			{8,8,2,5,3,1,4},
			{8,7,3,0,1,2,4},
			{32,15,7,9,11,2,1},
			{131072,13172,7,7,1,0,0},
			{131072,131070,411,415,398,463,9191}
		};
		
		for (int i = 0; i< input.length; i++)
			System.out.println(xorSequence.getmax(input[i][0], input[i][1], input[i][2], input[i][3], input[i][4], input[i][5], input[i][6]));
		
	}
	
	public long getmax(int N, int sz, int A0, int A1, int P, int Q, int R) {
		long[] A = new long[sz];
		
		A[0] = A0;
		A[1] = A1;
		
		for (int i = 2; i < sz; i++)
		    A[i] = (A[i - 2] * P + A[i - 1] * Q + R) % N;
		
		/*
		boolean allEqual = true;
		
		for (int j = 1; j < sz && allEqual; j++)
			allEqual = (A[j - 1] != A[j]);
		*/

		long max = 0;
		
		// problem!! time complexity is cubic in sz...
		for (int b = 0, count = 0; b < sz; b++, count = 0) {
			for (int j = sz - 1; j > 0; j--)
				for (int i = j - 1; i >= 0; i--)
					if ((A[i] ^ b) < (A[j] ^ b))
						count++;
			
			if (count > max)
				max = count;
		}	
				
		
		return max;
	}

}
