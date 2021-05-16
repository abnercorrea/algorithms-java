// time: worst-case: O(n), best-case: O(log(n)) - space: O(1)
public static TreeNode inOrderSuccessor(TreeNode node) {
    if (node == null) return null;

    TreeNode successor = null;

    if (node.right != null) {
        successor = node.right;

        while (successor.left != null) successor = successor.left;
    }
    else {
        successor = node.parent;
        
        while (successor != null && node == successor.right) {
            node = successor;
            successor = successor.parent;
        }
    }

    return successor;
}

// test
inOrderSuccessor(node4).value;
inOrderSuccessor(node3).value;
inOrderSuccessor(node7);

// debug
4
    2
        1
        3
    6
        5
        7
node: 4
successor: 6,5 OK
node: 3,2
successor: 2,4 OK
node: 7,6,4
successor: 6,4,null OK





// First atempt... tried to use in order traversal... didn't work
public static TreeNode inOrderSuccessor(TreeNode root, TreeNode node) {
    if (root == null || node == null) return null;

    return inOrderSuccessor(root, node, false);
}

public static TreeNode inOrderSuccessor(TreeNode root, TreeNode node, boolean returnNext) {
    if (root == null || node == null) return null;

    inOrderSuccessor(root.left, node, returnNext);

    if (returnNext) {
        System.out.println(root.value);

        return root;
    }
    
    if (root == node)
        returnNext = true; 

    inOrderSuccessor(root.right, node, returnNext);

    return null;
}
