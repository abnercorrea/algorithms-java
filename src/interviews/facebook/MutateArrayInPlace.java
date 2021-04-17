package interviews.facebook;

import java.util.Arrays;

public class MutateArrayInPlace {

	public static void main(String[] args) {
		int[] input = {1,2,3,4,5};
		int[] newPos = {2,0,4,1,3};

		mutateArray(input, newPos);
		
		System.out.println(Arrays.toString(input));
	}

	public static void mutateArray(int[] input, int[] newPos) {
	    mutateArray(input, newPos, 0, input[0]);    
	}

	public static void mutateArray(int[] input, int[] newPos, int index, int value) {
	    if (index < input.length - 1)
	    	mutateArray(input, newPos, index + 1, input[index + 1]);
	    
	    input[newPos[index]] = value;
	}
}
