// time: O(n), space: O(H)
public static int checkHeight(TreeNode node) {
    if (node == null) return 0;

    int leftHeight = checkHeight(node.left);
    if (leftHeight == -1) return -1;

    int rightHeight = checkHeight(node.right);
    if (rightHeight == -1) return -1;

    // check if node is balanced
    if (Math.abs(leftHeight - rightHeight) > 1) return -1;

    return Math.max(leftHeight, rightHeight) + 1;
}

public static boolean isBalanced(TreeNode node) {
    return checkHeight(node) != -1;
}

// First implementation

// time: O(n), space: O(n)recursion
public static int treeHeight(TreeNode node) {
    if (node == null) return 0;

    return 1 + Math.max(treeHeight(node.left), treeHeight(node.right));
}

// CAUTION! edge case (empty tree is balanced)?
// time: O(n^2), space: O(n)recursion                                                                                                                                                 
public static boolean isBalanced(TreeNode node) {
    if (node == null) return true;

    int diff = Math.abs(treeHeight(node.left) - treeHeight(node.right));
    boolean balanced = (diff < 2);
    
    return balanced && isBalanced(node.left) && isBalanced(node.right);
}

// Test
