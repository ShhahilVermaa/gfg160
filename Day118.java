/*You are given a string s and a list dictionary[] of words. Your task is to determine whether the string s can be formed by concatenating one or more words from the dictionary[].

Note: From dictionary[], any word can be taken any number of times and in any order.*/

class Solution {
    public boolean wordBreak(String s, String[] dictionary) {
        // code here
        int n = s.length();
        HashSet<String> ws = new HashSet<>(Arrays.asList(dictionary));
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        int maxl = 0;
        for(String w: dictionary){
            maxl = Math.max(maxl, w.length());
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = Math.max(i - maxl, 0); j < i; j++){
                if(dp[j] && ws.contains(s.substring(j , i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
