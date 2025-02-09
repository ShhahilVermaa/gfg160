//Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.

class Solution {
    // Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        helper(node , maxSum);
        return maxSum[0];
    }
    private int helper(Node node , int[] maxSum){
        if(node == null) return 0;
        int left = Math.max(0 , helper(node.left , maxSum));
        int right = Math.max(0 , helper(node.right , maxSum));
        maxSum[0] = Math.max(maxSum[0] , left + right + node.data);
        return node.data + Math.max(left,right);
        
    }
}
