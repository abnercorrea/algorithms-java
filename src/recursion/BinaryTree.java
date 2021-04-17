package recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class BinaryTree<T> {

	private Node root;
	
	public class Node {
		T value;
		
		Node left;
		Node right;
	}

	public BinaryTree() {
	}

	public BinaryTree(T[] values) {
		root = buildTree(values, 0);
	}

	private Node buildTree(T[] values, int i) {
		if (i >= values.length) 
			return null;
		
		Node treeNode = new Node();
		treeNode.value = values[i];
		
		treeNode.left = buildTree(values, (i << 1) + 1); // Builds left tree. (i << 1) + 1 = i*2 + 1 = left child index in array representation
		treeNode.right = buildTree(values, (i << 1) + 2); // Builds right tree. (i << 1) + 2 = i*2 + 2 = right child index in array representation
		
		return treeNode;
	}

	public int height() {
		return nodeHeight(root);
	}
	
	private int nodeHeight(Node node) {
		if (node == null) 
			return 0;
		
		return 1 + Math.max(nodeHeight(node.left), nodeHeight(node.right));
	}

	public void inOrder() {
		inOrder(root, null);
	}
	
	public void inOrder(Consumer<Node> visit) {
		inOrder(root, visit);
	}
	
	private void inOrder(Node node, Consumer<Node> visit) {
		if (node == null) 
			return;
		
		inOrder(node.left, visit);

		if (visit != null) visit.accept(node); else visitNode(node);
		
		inOrder(node.right, visit);
	}

	private void visitNode(Node node) {
		System.out.print(node.value.toString() + ", ");
	}

	public void postOrder() {
		postOrder(root);
	}
	
	private void postOrder(Node node) {
		if (node == null) 
			return;

		postOrder(node.left);
		postOrder(node.right);

		visitNode(node);				
	}

	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node node) {
		if (node == null) 
			return;

		visitNode(node);
		
		preOrder(node.left);
		preOrder(node.right);
	}

	public void breadthFirst() {
		if (root == null) 
			return;

		Queue<Node> visitQueue = new LinkedList<>();

		visitQueue.add(root);
		
		while (!visitQueue.isEmpty()) {
			Node node = visitQueue.poll();
			
			visitNode(node);
			
			if (node.left != null) 
				visitQueue.add(node.left);
			if (node.right != null) 
				visitQueue.add(node.right);
		}
	}
	
	public static void main(String[] args) {
		Integer[] numbers = new Integer[] { 3,9,17,4,33,21,16,1 };
		
		BinaryTree<Integer> tree = new BinaryTree<>(numbers);
		
		System.out.println("Input array: " + Arrays.toString(numbers));
		
		System.out.println("Inorder: ");
		tree.inOrder();
		System.out.println();
		
		System.out.println("Inorder Custom (square): ");
		tree.inOrder((BinaryTree<Integer>.Node n) -> System.out.print(n.value * n.value + ", "));
		System.out.println();
		
		System.out.println("Preorder: ");
		tree.preOrder();
		System.out.println();

		System.out.println("Postorder: ");
		tree.postOrder();
		System.out.println();
		
		System.out.println("BreadthFirst: ");
		tree.breadthFirst();
		System.out.println();
		
		System.out.println("Height: " + tree.height());
		
		
	}
	
}
