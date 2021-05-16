// Questions:
// Is there a link to parent node? if yes you can have a lot more ways
// What to return? 

// return data structure
// path is a string in the format: "LRRLR", indicating a sequence of moves (left or right)
class TreePath {
    TreeNode start;
    String path;
    
    public TreePath(TreeNode start, String path) {
        this.start = start;
        this.path = path;
    }
}

// finds all paths that sum to value. (recursive)
public static void findSumPaths(TreeNode root, int value, List<TreePath> paths, TreeNode start, String path) {
    if (root == null) return;
    
    if (value == root.value) {
        paths.add(new TreePath(start, path));
        
        return;
    }
    
    findSumPaths(root.left, value - root.value, paths, start, path + "L");
    // Careful with copy and paste!!!
    findSumPaths(root.right, value - root.value, paths, start, path + "R");
}

// traverses the tree in pre order finding all paths that sum to value starting from root.
// CAUTION!! same as problem 4.8... use pathSumTo to traverse the tree and findSumPaths to actually "visit" the node
// and search for sum paths.
public static void pathSumTo(TreeNode root, int value, List<TreePath> paths) {
    if (root == null) return;
    
    // generate all paths from root
    findSumPaths(root, value, paths, root, "");
    
    pathSumTo(root.left, value, paths);
    pathSumTo(root.right, value, paths);
}

// Just a wrapper
public static List<TreePath> pathSumTo(TreeNode root, int value) {
    if (root == null) return null;
    
    List<TreePath> paths = new ArrayList();
    
    pathSumTo(root, value, paths);
    
    return paths;
}

// test
import java.util.stream.IntStream;
TreeNode bstSum = buildBinarySearchTree(IntStream.range(0, 100).toArray());

List<TreePath> sumPaths = pathSumTo(bstSum, 81);

// lets use streams
sumPaths.stream().forEach(p -> {
    System.out.println(p.start.value + " " + p.path);
    System.out.println(p.start.value);
    TreeNode node = p.start;
    for (int i = 0; i < p.path.length(); i++) {
        node = (p.path.charAt(i) == 'L') ? node.left : node.right;
        System.out.println(node.value);
    } 
    System.out.println();
})

