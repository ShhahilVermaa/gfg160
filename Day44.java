//Given a string s, find the length of the longest substring with all distinct characters. 
class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int n = s.length();
        if(n == 0) return 0;
        
        int[]charI = new int[26];
        int maxL = 0;
        int left =0;
        
        for(int right=0;right<n;right++)
        {
            char curr = s.charAt(right);
            int charP = curr - 'a';
            if(charI[charP] > 0)
            {
                left = Math.max(left,charI[charP]);
            }
            charI[charP] = right  + 1;
            maxL = Math.max(maxL,right-left+1);
        }
        return maxL;
    }
}
