public static TreeNode buildBinarySearchTree(int[] values) {
    if (values == null) return null;

    return buildBinarySearchTree(values, 0, values.length - 1);
}

public static TreeNode buildBinarySearchTree(int[] values, int start, int end) {
    if (start > end) return null;

    int middle = (start + end) >>> 1;
    
    TreeNode node = new TreeNode(values[middle], null, null);
    node.left = buildBinarySearchTree(values, start, middle - 1);
    node.right = buildBinarySearchTree(values, middle + 1, end);

    return node;
}

// test
int[] values = { 1,2,3,4,5,6,7 }

TreeNode bst1 = buildBinarySearchTree(values);

// REMINDER!!! inOrder traversal for a binary search tree prints elements SORTED.
inOrder(bst1);

// debug
values: 1,2,3,4,5,6,7
start:0,0,0,0,1,2
end: 6,2,0,-1,0,2
middle: 3,1,0,2
Tree
4
    2
        1
            null
            null
        3
            null
            null
    6
        5
            null
            null
        7
            null
            null