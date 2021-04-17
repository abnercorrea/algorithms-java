package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public void binaryTreePaths(TreeNode root, String path, List<String> paths) {
        if (root == null) return;

        path = (path.isEmpty()) ? String.valueOf(root.val) : path + "->" + root.val;

        if (root.left == null && root.right == null) { // leaf
            paths.add(path);

            return;
        }

        binaryTreePaths(root.left, path, paths);
        binaryTreePaths(root.right, path, paths);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList();

        binaryTreePaths(root, "", paths);

        return paths;
    }
}
