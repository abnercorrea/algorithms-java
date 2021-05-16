// time: O(n), space: O(1)
public static Node partitionList(Node root, int x) {
    if (root == null) return null;
    
    boolean foundHigherEq = root.value >= x;
    Node n = root.next, prev = root;
    
    // CAUTION!!! using "for" here caused problems, since you can't update n and prev every iteration 
    while (n != null) {
        // Since the problem states that the partition will have values lower than x to the left and 
        // greater than OR EQUAL to the right, the condition has to be value < x and NOT value <= x.
        if (n.value < x && foundHigherEq) {
            prev.next = n.next;
            n.next = root;
            root = n;
            // CAUTION!! Needs to update n!!! 
            n = prev.next; // originally n.next
        }
        else {
            foundHigherEq = n.value >= x;
            n = n.next;
            prev = prev.next;
        }
    }
    
    // Caution!!! Needs to return new ROOT since it might change
    return root;
}

// debug
5-1-3-4-7-2-9-0-1
root = 5,1,2,0,1
x = 3
foundHigher=true
n = 1,3,4,7,2,9,0,1,null
prev = 5,3,4,7,9
1-5-3-4-7-2-9-0-1
2-1-5-3-4-7-9-0-1
0-2-1-5-3-4-7-9-1
1-0-2-1-5-3-4-7-9

// test
Node list3 = partitionList(list1, 3)
