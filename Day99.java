/*Given a string s, return the length of the longest palindromic subsequence.

A subsequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the order of the remaining elements.

A palindromic sequence is a sequence that reads the same forward and backward.*/
class Solution {
    public int longestPalinSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for(int i = 0; i < n ; i++){
            dp[i][i] = 1;
        }
        for(int l = 2 ; l <= n ; l++){
            for(int i = 0 ; i <= n - l ; i++){
                int j = i + l - 1;
                
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2 + (i + 1 <= j - 1 ? dp[i + 1][j - 1] : 0);
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
