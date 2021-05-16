// time: O(n), space: O(n)
public static void removeDuplicates(Node head) {
    if (head == null) return;
    
    Set<Integer> elements = new HashSet();
     
    for (Node node = head, prev = head; node != null; node = node.next)
        if (elements.contains(node.value))
            prev.next = node.next;
        else {
            elements.add(node.value);
            prev = node;
        }
}

// time: O(n^2), space: O(1)
public static void removeDuplicatesNoAux(Node node) {
    if (node == null) return;
    
    // CAUTION!!! any type can be used in for variable... like Node
    for (Node A = node; A.next != null; A = A.next)
        // For is powerfull for working with pointers... but code might look less clear
        for (Node B = A.next, prev = A; B != null; B = B.next)
            if (A.value == B.value)
                prev.next = B.next;
            else 
                prev = B;
}

// Debug
1-2-3-4-2-1-5-6-7-null
elements: 1, 2, 3, 4, 5   
prev = 1, 2, 3, 4, 5, 6, 7
node = 1, 2, 3, 4, 2, 1, 5, 6, 7, null
1-2-3-4-1-5-6-7
1-2-3-4-5-6-7

removeDuplicates(list1)
removeDuplicates(list2)
printList(list1)
printList(list2)
removeDuplicates(null)

removeDuplicatesNoAux(list1)
printList(list1)
removeDuplicatesNoAux(null)
