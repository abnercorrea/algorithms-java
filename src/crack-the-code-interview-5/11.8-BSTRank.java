class RankBSTNode {
    int value;
    int leftSize = 0;
    
    RankBSTNode left = null, right = null;
    
    public RankBSTNode(int x) { value = x; }    
}

class RankBST {
    RankBSTNode root = null;
    
    public void track(int x) {
        if (root == null)
            root = new RankBSTNode(x);
        else
            insert(root, x);        
    }
    
    public void insert(RankBSTNode node, int x) {
        if (node == null) return;
        
        if (x <= node.value) {
            node.leftSize++;
            
            if (node.left == null)
                node.left = new RankBSTNode(x);
            else
                insert(node.left, x);        
        }
        else   
            if (node.right == null)
                node.right = new RankBSTNode(x);
            else
                insert(node.right, x);        
    }
    
    public int getRankOfNumber(int x) {
        return getRankOfNumber(root, x);       
    }

    public int getRankOfNumber(RankBSTNode node, int x) {
        if (node == null) return -1;
        
        if (node.value == x) return node.leftSize;
        
        if (x < node.value)
            return getRankOfNumber(node.left, x);       
        else {
            // CAUTION!! treat -1 return
            int rightRank = getRankOfNumber(node.right, x);
            
            return (rightRank == -1) ? -1 : node.leftSize + 1 + rightRank;       
        }
    }

    public Integer getKthElement(int k) {
        return getKthElement(root, k);
    }
    
    public Integer getKthElement(RankBSTNode node, int k) {
        if (node == null) return null;
        
        if (k == node.leftSize + 1) return node.value;
        
        // CAUTION!!! condition is <=
        if (k <= node.leftSize)
            return getRankOfNumber(node.left, k);       
        else 
            return getRankOfNumber(node.right, k - node.leftSize - 1);
    }
}

// test
RankBST rbst = new RankBST();
rbst.track(20); 
rbst.track(15); 
rbst.track(25);
rbst.track(10); 
rbst.track(23); 
rbst.track(5); 
rbst.track(13); 
rbst.track(24);

rbst.getRankOfNumber(20); 
rbst.getRankOfNumber(15); 
rbst.getRankOfNumber(25);
rbst.getRankOfNumber(10); 
rbst.getRankOfNumber(23); 
rbst.getRankOfNumber(5); 
rbst.getRankOfNumber(13); 
rbst.getRankOfNumber(24);

rbst.getKthElement(1);
 
 
// Algorithm
- An array would give bad performance on operation track(x)... O(n)
- Lets use a binary SEARCH tree (BST), and consider it's balanced... search and insert are O(log(n))
- As an optimization for rank(x), each node of the BST will contain the size of the left subtree.
    if we go left, do not increase rank
    if we go right, increase rank by left_size + 1
