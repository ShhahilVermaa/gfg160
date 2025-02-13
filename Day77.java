//Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target. 


class Solution {
    boolean findTarget(Node root, int target) {
        // Write your code here
        HashSet<Integer> set = new HashSet<>();
        return findPair(root , target , set);
    }
    private boolean findPair(Node node , int target , HashSet<Integer>set){
        if(node == null) return false;
        if(set.contains(target - node.data)) return true;
        set.add(node.data);
        return findPair(node.left , target , set) || findPair(node.right , target , set);
    }
}
