// Invert and compare takes n extra space while using the stack takes n/2
// time: O(n), space: O(n)
public static boolean isPalindrome(Node root) {
    if (root == null) return false;

    // using a stack, you need n/2 extra space as opposed to n when reversing the list and comparing.
    Stack<Node> nodes = new Stack();

    Node n = root, runner = root;

    // runner moving twice as fast as n so we can find the middle of the list
    while (runner != null) {
        runner = runner.next;

        if (runner != null) {
            runner = runner.next;
            // pushing in the stack here will not push the middle element in case of a list with an odd size.
            nodes.push(n);
        }

        if (runner != null) n = n.next;
    }

    // initial value of right will be n.next for both odd and even list sizes.
    for (Node right = n.next; right != null; right = right.next) {
        Node left = nodes.pop();

        if (left.value != right.value) return false;
    }

    return true;
}

// debug
1-2-3
2
3,null

1-2-3-4-5-6
2,3
3,5,null