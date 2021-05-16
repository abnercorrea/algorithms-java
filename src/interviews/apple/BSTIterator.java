// Implement an iterator for a binary search tree that will iterate the nodes by value in ascending order
class TreeNode<T> {
    T value;

    TreeNode left, right, parent = null;

    public TreeNode(T value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BSTInOrderIterator<T> implements Iterator<T> {
    public TreeNode<T> current;

    public BSTInOrderIterator(TreeNode<T> root) {
        if (root == null) return;

        for (current = root; current.left != null; ) current = current.left;
    }

    public boolean hasNext() {
        return current != null; 
    }

    public T next() {
        T value = current.value;

        if (current.right != null) {
            for (current = current.right; current.left != null; ) current = current.left;
        }
        else {
            TreeNode<T> prev = current;
            
            for (current = current.parent; current != null && current.right == prev; current = current.parent) prev = current;
        }

        return value;
    }
}

public class BST<T> implements Iterable<T> {
    public TreeNode<T> root;

    public BST(T[] values) {
        root = build(values);
    }

    public Iterator<T> iterator() {
        return new BSTInOrderIterator(root);
    }

    private static <U> TreeNode<U> build(U[] values, int start, int end, TreeNode<U> parent) {
        if (start > end) return null;

        int middle = (start + end) >>> 1;
        
        TreeNode<U> node = new TreeNode(values[middle], null, null);
        node.left = build(values, start, middle - 1, node);
        node.right = build(values, middle + 1, end, node);
        node.parent = parent;

        return node;
    }

    public static <U> TreeNode<U> build(U[] values) {
        if (values == null) return null;

        Arrays.sort(values);

        return build(values, 0, values.length - 1, null);
    }

}


Integer[] values = {10,1,20,2,30,3,40,4,50,5,60,6,70,7,80,8,90,9,100,10}
BST<Integer> bst1 = new BST(values)

for (Integer i: bst1) System.out.println(i)
