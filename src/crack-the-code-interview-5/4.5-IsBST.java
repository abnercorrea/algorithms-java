// time: O(n), space: O(log(n)) - space is log(n) on a balanced tree due to the recursion
public static boolean isBST(TreeNode node) {
    return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

public static boolean isBST(TreeNode n, int min, int max) {
    // CAUTION!! empty tree is a BST
    if (n == null) return true;
    
    if (n.value < min || n.value > max) return false;
    
    return isBST(n.left, min, n.data) && isBST(n.right, n.data, max);
}
