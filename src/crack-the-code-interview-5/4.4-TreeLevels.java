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

// Final version
public static List<LinkedList<TreeNode>> treeLevels(TreeNode root) {
    if (root == null) return null;

    List<LinkedList<TreeNode>> levels = new ArrayList();
    
    levels.add(new LinkedList<TreeNode>());
    levels.get(0).add(root);    
    
    for  (int level = 1; !levels.get(level - 1).isEmpty(); level++) {
        if (level == levels.size()) levels.add(new LinkedList<TreeNode>()); 

        for (TreeNode node : levels.get(level - 1)) {
            if (node.left != null) levels.get(level).add(node.left);
            if (node.right != null) levels.get(level).add(node.right);
        }
    }

    levels.remove(levels.size() - 1);

    return levels;
} 

// test
List<LinkedList<TreeNode>> tl1 = treeLevels(tree1);

// lets use streams
tl1.stream().forEach( (LinkedList<TreeNode> level) -> { 
    level.stream().forEach((TreeNode node) -> System.out.print(node.value + ","));
    System.out.println(); 
});

// debug
root: (4(2(1)(3))(6(5)(7)))
levels: { {4}, {2,6}, {1,3,5,7} }
level: 1,2,3

// First Atempt...
public static List<LinkedList<TreeNode>> treeLevels2(TreeNode root) {
    if (root == null) return null;

    List<LinkedList<TreeNode>> levels = new ArrayList();
    Queue<TreeNode> nodes = new LinkedList();
    Queue<Integer> nodeLevel = new LinkedList();

    nodes.add(root);    
    nodeLevel.add(0);

    while (!nodes.isEmpty()) {
        TreeNode node = nodes.remove();
        int level = nodeLevel.remove();

        if (level == levels.size()) levels.add(new LinkedList<TreeNode>()); 

        levels.get(level).add(node);

        if (node.left != null) {
            nodes.add(node.left);
            nodeLevel.add(level + 1);
        }

        if (node.right != null) {
            nodes.add(node.right);
            nodeLevel.add(level + 1);
        }
    }

    return levels;
}


