//Given a binary tree and an integer k, determine the number of downward-only paths where the sum of the node values in the path equals k. A path can start and end at any node within the tree but must always move downward (from parent to child).

class Solution {
    public int sumK(Node root, int k) {
        HashMap<Integer , Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0,1);
        return dfs(root,0,k,prefixSumCount);
    }
    private int dfs(Node node , int currSum , int k , HashMap<Integer , Integer> prefixSumCount){
        if(node == null) return 0;
        currSum += node.data;
        int count = prefixSumCount.getOrDefault(currSum - k, 0);
        prefixSumCount.put(currSum,prefixSumCount.getOrDefault(currSum, 0) + 1);
        count += dfs(node.left , currSum ,k , prefixSumCount);
        count += dfs(node.right , currSum ,k ,prefixSumCount);
        prefixSumCount.put(currSum,prefixSumCount.get(currSum)-1);
        return count;
    }
}
