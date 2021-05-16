 class GraphNode {
    int value;

    GraphNode[] adjacent;

    public GraphNode(int value, GraphNode[] adjacent) {
        this.value = value;
        this.adjacent = adjacent;
    }
}

class Graph {
    GraphNode[] nodes;
}
 
public static void visit(GraphNode node) {
    System.out.println(node.value);
}

// Depth First Search
public static void DFS(GraphNode graph) {
    if (graph == null) return;

    visit(graph);

    // CAUTION!!! watch foreach syntax
    // CAUTION!!! check if graph.adjacent is null
    if (graph.adjacent != null)
        for (GraphNode adjacent: graph.adjacent) DFS(adjacent);
}

// Breadth First Search
public static void BFS(GraphNode root) {
    if (graph == null) return;

    Queue<GraphNode> nodeQueue = new LinkedList();

    nodeQueue.add(root);

    while (!nodeQueue.isEmpty()) {
        GraphNode node = nodeQueue.remove();

        visit(node);

        // CAUTION!!! check if adjacent is null
        if (node.adjacent != null)
            Arrays.stream(node.adjacent).forEach(nodeQueue::add);
            //for (GraphNode adjacent: node.adjacent) nodeQueue.add(adjacent);
    }
}

GraphNode[] nodeA4 = { new GraphNode(13, null) }
GraphNode[] nodeA3 = { new GraphNode(8, null), new GraphNode(9, null), new GraphNode(10, null), new GraphNode(11, null), new GraphNode(12, null) } 
GraphNode[] nodeA2 = { new GraphNode(6, null), new GraphNode(7, null) }
GraphNode[] nodeA1 = { new GraphNode(2, null), new GraphNode(3, nodeA2), new GraphNode(4, nodeA3), new GraphNode(5, nodeA4) }

GraphNode graphNode1 = new GraphNode(1, nodeA1)


