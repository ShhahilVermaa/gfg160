/*Given a string s, your task is to find the longest palindromic substring within s.

A substring is a contiguous sequence of characters within a string, defined as s[i...j] where 0 ≤ i ≤ j < len(s).

A palindrome is a string that reads the same forward and backward. More formally, s is a palindrome if reverse(s) == s.

Note: If there are multiple palindromic substrings with the same length, return the first occurrence of the longest palindromic substring from left to right.*/

class Solution {
    static String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        String longest = "";
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            String odd = expandAroundCenter(s,i,i);
            String even = expandAroundCenter(s,i,i+1);
            if(odd.length() > longest.length()){
                longest = odd;
            }
            
            if(even.length() > longest.length()){
                longest = even;
            }
        }
        return longest;
    }
    private static String expandAroundCenter(String s, int left ,int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left + 1 , right);
    }
}
