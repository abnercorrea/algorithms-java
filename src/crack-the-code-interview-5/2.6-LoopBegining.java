// time: O(n), space: O(n)
public static Node loopBegining1(Node root) {
    if (root == null) return null;
    
    Set<Node> visited = new HashSet();
    
    for (Node n = root; n != null; n = n.next) {
        if (visited.contains(n)) return n;
        
        visited.add(n);
    }
    
    return null;
}

// time: O(n^2), space: O(1)
public static Node loopBegining2(Node root) {
    if (root == null) return null;
    
    for (Node n = root; n.next != null; n = n.next)
        for (Node m = n.next; m != null; m = m.next)
            if (n == m) return n;
    
    return null;
}

//test    
Node a = new Node(1, null);
Node b = new Node(2, null);
Node c = new Node(3, null);
Node d = new Node(4, null);
Node e = new Node(5, null);
a.next = b;
b.next = c;
c.next = d;
d.next = e;
e.next = c;

loopBegining1(a);
loopBegining2(a);
