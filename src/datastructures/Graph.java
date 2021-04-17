package datastructures;

import java.util.LinkedList;

public class Graph<T> {
	
	private GraphNode root;
	
	public class GraphNode {
		T value;
		GraphNode[] neighbors;

		boolean visited = false;

		public GraphNode() {
		}
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
	}
}
