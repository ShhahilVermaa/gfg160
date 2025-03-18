/*Given an array arr[], determine if it can be partitioned into two subsets such that the sum of elements in both parts is the same.

Note: Each element must be in exactly one subset.*/
class Solution {
    static boolean equalPartition(int arr[]) {
        // code here
        int sum = 0;
        int n = arr.length;
        
        for(int num : arr){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        
        int target = sum/2;
        boolean dp[][] = new boolean[n+1][target + 1];
        
        for(int i = 0 ; i <= n ; i++){
            dp[i][0] = true;
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= target ; j++){
                if(arr[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[n][target];
    }
}
