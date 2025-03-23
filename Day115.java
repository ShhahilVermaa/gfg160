/*A message containing letters A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

You are given a string digits. You have to determine the total number of ways that message can be decoded.*/

class Solution {
    public int countWays(String digits) {
        if(digits == null || digits.length() == 0 || digits.charAt(0) == '0'){
            return 0;
        }
        int n = digits.length();
        int prev2 = 1 , prev1 = 1;
        
        for(int i = 2 ; i <= n ; i++){
            int curr = 0;
            char single = digits.charAt(i-1);
            int twoDigit = Integer.parseInt(digits.substring(i - 2 , i));
            
            if(single != '0'){
                curr += prev1;
            }
            if(twoDigit >= 10 && twoDigit <= 26){
                curr += prev2;
            }
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
