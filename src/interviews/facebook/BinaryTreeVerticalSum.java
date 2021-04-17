package interviews.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BinaryTreeVerticalSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(1);
		TreeNode B = new TreeNode(2);
		TreeNode C = new TreeNode(3);
		TreeNode D = new TreeNode(4);
		TreeNode E = new TreeNode(5);
		TreeNode F = new TreeNode(6);
		TreeNode G = new TreeNode(7);
		TreeNode H = new TreeNode(8);
		TreeNode I = new TreeNode(9);
		
		A.left = B;
		A.right = C;
		B.left = H;
		C.left = D;
		D.left = I;
		D.right = E;
		H.left = F;
		I.left = G;

		Map<Integer, Integer> verticalSum = calculateVerticalSum(A, new HashMap<Integer, Integer>(), 0);
		
		for (Entry<Integer, Integer> e : verticalSum.entrySet()) 
			System.out.println("Vertical level: " + e.getKey() + " Sum: " + e.getValue());

	}

	public static Map<Integer, Integer> calculateVerticalSum(TreeNode root, Map<Integer, Integer> sum, int verticalIndex) {
		if (root == null) 
			return sum;
		
		Integer verticalSum = sum.containsKey(verticalIndex) ? sum.get(verticalIndex) : 0;
		
		sum.put(verticalIndex, verticalSum + root.value);
		
		calculateVerticalSum(root.left, sum, verticalIndex - 1);
		calculateVerticalSum(root.right, sum, verticalIndex + 1);
		
		return sum;
	}
	
	static class TreeNode {
		int value;
		
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int value) {
			this.value = value;
		}
	}

 }
