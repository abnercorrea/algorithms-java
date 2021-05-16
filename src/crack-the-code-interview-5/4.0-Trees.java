/*
-Binary Search Tree: for all nodes, left children <= current node <= right children
-Balanced vs. Unbalanced: In a balanced tree, the depth of the left and right subtrees of every node differ by 1 or less.
-Full Binary Tree: every node other than the leaves has two children.
-Complete Binary Tree: a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible
-Perfect Binary Tree: a full binary tree in which all leaves are at the same depth or same level, and in which every parent has two children.
-The depth of a node is the number of edges from the node to the tree's root node. A root node will have a depth of 0. 
-The height of a node is the number of edges on the longest path from the node to a leaf. A leaf node will have a height of 0.
*/

class TreeNode {
    int value;

    TreeNode left, right, parent = null;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

TreeNode tree1 = new TreeNode(1, 
    new TreeNode(2, 
        new TreeNode(4, null, null), 
        new TreeNode(5, null, null)), 
    new TreeNode(3, 
        new TreeNode(6, null, null), 
        new TreeNode(7, null, null))
)

TreeNode bst1node5 = new TreeNode(5, null, null);
TreeNode bst1 = new TreeNode(4, 
    new TreeNode(2, 
        new TreeNode(1, null, null), 
        new TreeNode(3, null, null)), 
    new TreeNode(6, 
        bst1node5, 
        new TreeNode(7, null, null))
)

TreeNode node7 = new TreeNode(7, null, null)
TreeNode node5 = new TreeNode(5, null, null)
TreeNode node3 = new TreeNode(3, null, null)
TreeNode node1 = new TreeNode(1, null, null)
TreeNode node6 = new TreeNode(6, node5, node7)
TreeNode node2 = new TreeNode(2, node1, node3)
TreeNode node4 = new TreeNode(4, node2, node6)
node2.parent = node4;
node1.parent = node2;
node3.parent = node2;
node6.parent = node4;
node5.parent = node6;
node7.parent = node6;

public static void visit(TreeNode node) {
    System.out.println(node.value);
}

// Visits node, left then right
public static void preOrder(TreeNode node) {
    if (node == null) return;

    visit(node);

    preOrder(node.left);
    preOrder(node.right);
}

// Visits left, node then right
// REMINDER!!! inOrder traversal for a binary search tree prints elements SORTED.
public static void inOrder(TreeNode node) {
    if (node == null) return;

    inOrder(node.left);

    visit(node);

    inOrder(node.right);
}

// Visits left, right then node
public static void postOrder(TreeNode node) {
    if (node == null) return;
    
    postOrder(node.left);
    postOrder(node.right);

    visit(node);
}

// returns true if node is a descendant of root
public static boolean covers(TreeNode root, TreeNode node) {
    if (root == null) return false;
    
    if (root == node) return true;
    
    return covers(root.left, node) || covers(root.right, node);
}

// returns the hight of the tree
public static int treeHeight(TreeNode root) {
    if (root == null) return 0;

    return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
}

public static boolean isBalanced(TreeNode node) {
    if (node == null) return true;

    int diff = Math.abs(treeHeight(node.left) - treeHeight(node.right));
    boolean balanced = (diff < 2);
    
    return balanced && isBalanced(node.left) && isBalanced(node.right);
}

public static TreeNode buildBinarySearchTree(int[] values, int start, int end) {
    if (start > end) return null;

    int middle = (start + end) >>> 1;
    
    TreeNode node = new TreeNode(values[middle], null, null);
    node.left = buildBinarySearchTree(values, start, middle - 1);
    node.right = buildBinarySearchTree(values, middle + 1, end);

    return node;
}

public static TreeNode buildBinarySearchTree(int[] values) {
    if (values == null) return null;

    return buildBinarySearchTree(values, 0, values.length - 1);
}

public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> nodeValues = new ArrayList<Integer>();
    if(root == null)
        return al;
 
    LinkedList<TreeNode> current = new LinkedList<TreeNode>();
    LinkedList<TreeNode> next = new LinkedList<TreeNode>();
    current.add(root);
 
    while(!current.isEmpty()){
        TreeNode node = current.remove();
 
        if(node.left != null)
            next.add(node.left);
        if(node.right != null)
            next.add(node.right);
 
        nodeValues.add(node.val);
        if(current.isEmpty()){
            current = next;
            next = new LinkedList<TreeNode>();
            al.add(nodeValues);
            nodeValues = new ArrayList();
        }
 
    }
    return al;
}
    