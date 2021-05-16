// BFS Breadth First Search
public static boolean existsRoute(Graph graph, GraphNode src, GraphNode dst) {
    if (graph == null || src == null || dst == null) return false;

    Queue<GraphNode> nodeQueue = new LinkedList();

    for (GraphNode node: graph.nodes) node.state = State.unvisited;
        
    src.state = State.visiting;
    nodeQueue.add(src);
    
    while (!nodeQueue.isEmpty()) {
        // CAUTION!!! use poll() so it returns null on empty q. remove() throws E
        GraphNode node = nodeQueue.poll();

        if (node != null) {
            for (GraphNode a: node.adjacent) {
                if (a.state == State.unvisited) {
                    if (a == dst) 
                        return true;
                    else {
                        a.state = State.visiting;
                        nodeQueue.add(a);
                    }
            }
            
            node.state = State.visited;
        }
    }

    return false;
}

