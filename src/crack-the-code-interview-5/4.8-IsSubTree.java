// Questions:
// Trees are to be compared by node value? (and not node reference)

// Checks if 2 trees are identical by comparing node values
public static boolean equalTrees(TreeNode a, TreeNode b) {
    if (a == null && b == null) return true;
    if (a == null || b == null) return false;
    
    return (a.value == b.value) && equalTrees(a.left, b.left) && equalTrees(a.right, b.right);
}

// Traverses a in pre order checking if b is a subtree
public static boolean isSubTree(TreeNode a, TreeNode b) {
    if (a == null && b == null) return true;
    if (a == null || b == null) return false;
    
    // CAUTION!!!!
    // traverse the tree using isSubTree (made a mistake and used equalTrees)
    // Preorder... node, left, right
    return equalTrees(a, b) || isSubTree(a.left, b) || isSubTree(a.right, b); 
}

// test
isSubTree(node4, node2)
isSubTree(node4, node1)
isSubTree(node4, node7)
isSubTree(node4, node6)
isSubTree(node4, new TreeNode(8, null, null))
isSubTree(node4, null)
