/* questions:
1- does each node have a link to its parent?
2- Do we have access to the root node?.
*/
// Avoid using a datastructure to store previously visited nodes

public static TreeNode commonAncestorHelper(TreeNode root, TreeNode a, TreeNode b) {
    if (root == null) return null;
    
    if (root == a || root == b) return root;
    
    TreeNode la = commonAncestorHelper(root.left, a, b);

    if (la != null && la != a && la != b) return la;

    TreeNode ra = commonAncestorHelper(root.right, a, b);

    if (ra != null && ra != a && ra != b) return ra;
    
    // root is
    if (la != null && ra != null) return root;
    
    return (la != null) ? la : ra;
}

public static TreeNode commonAncestor(TreeNode root, TreeNode a, TreeNode b) {
    if (root == null || a == null || b == null) return null;
    
    // either a or b are not in the tree
    if (!covers(root, a) || !covers(root, b)) return null;
    
    return commonAncestorHelper(root, a, b);
}

// test
commonAncestor(node4, node1, node3)

// Brute force...
// this solution requires each node to have a link to its parent
// time: O(log(n)^2) on a balanced tree, space: O(1)
public static TreeNode commonAncestor(TreeNode a, TreeNode b) {
    for (TreeNode pb = b; pb != null; pb = pb.parent)
        for (TreeNode pa = a; pa != null; pa = pa.parent)
            // Caution!! if a = b, the first common ancestor is either a or b, not their parent
            if (pa == pb) return pa;
    
    return null;
}

//test
commonAncestor(node1, node3)
