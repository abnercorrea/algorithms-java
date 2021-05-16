class Node {
    int value;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
} 

public class NodeDoubly {
    int value;
    
    NodeDoubly prev; 
    NodeDoubly next; 
    
    public NodeDoubly(int value, NodeDoubly prev, NodeDoubly next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}

public static void printList(Node node) {
    for (; node != null; node = node.next) 
        System.out.print(node.value + "->");
        
    System.out.println("null");
}

// time: O(n), space: O(1)
public static Node invertList(Node root) {
    Node prev = null, node = root, next = null;

    while (node != null) {
        next = node.next;
        node.next = prev;
        prev = node;
        node = next;
    }

    return prev;
}

//
Node list1 = new Node(1, new Node(2, new Node(1, null))) 
Node list2 = new Node(1, new Node(2, new Node(3, null))) 
Node list3 = new Node(1, new Node(2, new Node(1, new Node(1, new Node(2, new Node(1, null)))))) 
Node list4 = new Node(1, null) 
