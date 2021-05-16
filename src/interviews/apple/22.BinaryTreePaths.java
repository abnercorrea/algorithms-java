/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
*/

public void binaryTreePaths(TreeNode root, String path, List<String> paths) {
	if (root == null) return;
	
	path = ((path.isEmpty()) ? "" : path + "->") + root.val;
			
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

