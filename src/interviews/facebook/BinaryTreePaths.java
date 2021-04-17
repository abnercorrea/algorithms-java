package interviews.facebook;

import java.util.ArrayList;

public class BinaryTreePaths {

	public static void main(String[] args) {
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		Node F = new Node("F");
		Node G = new Node("G");
		Node H = new Node("H");
		Node I = new Node("I");
		
		A.left = B;
		A.right = C;
		B.left = H;
		C.left = D;
		D.left = I;
		D.right = E;
		H.left = F;
		I.left = G;
		
		System.out.println("Path to leaves for A");
		printPathToLeaves(A, new ArrayList<String>());
		System.out.println("Path to leaves for B");
		printPathToLeaves(B, new ArrayList<String>());
		System.out.println("Path to leaves for D");
		printPathToLeaves(D, new ArrayList<String>());
		System.out.println("Path to leaves for G");
		printPathToLeaves(G, new ArrayList<String>());
	}

	public static void printPathToLeaves(Node root, ArrayList<String> path) {
		if (root == null)
			return;
		
		if (root.left == null && root.right == null) { // leaf
			for (String s : path)
				System.out.print(s + " -> ");

			System.out.println(root.value);

			return;
		}
				
		path.add(root.value);

		printPathToLeaves(root.left, path);
		printPathToLeaves(root.right, path);		

		path.remove(path.size() - 1);
	}
	
	static class Node {
		String value;
		
		Node left;
		Node right;
		
		public Node(String value) {
			this.value = value;
		}
	}
}
