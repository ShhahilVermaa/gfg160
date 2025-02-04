//Given a binary tree, the diameter (also known as the width) is defined as the number of edges on the longest path between two leaf nodes in the tree. This path may or may not pass through the root. Your task is to find the diameter of the tree.
class Solution {
    int diameter(Node root) {
        int[] maxDiameter = new int[1];
        depth(root,maxDiameter);
        return maxDiameter[0];
    }
    int depth(Node node,int[] maxDiameter)
    {
        if(node == null){
            return 0;
        }
        int leftDepth = depth(node.left,maxDiameter);
        int rightDepth = depth(node.right,maxDiameter);
        maxDiameter[0] = Math.max(maxDiameter[0] , leftDepth + rightDepth);
        return Math.max(leftDepth,rightDepth) + 1 ;
    }
}
