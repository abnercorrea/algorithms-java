// Algorithm: Copy next node to current, delete next node (special case if last node)
// time: O(1), space: O(1)
public static void deleteNode(Node n) {
    // Caution!! if node is the last node of the list, it can't be deleted without accessing the previous node.
    // It could be made a dummy node
    if (n == null || n.next == null) return;
    
    Node next = n.next;
    n.value = next.value;
    n.next = next.next;
}

// Test
Node n = list1.next.next.next;
deleteNode(n)