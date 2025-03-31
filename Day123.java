/*Given a string s of lowercase English alphabets, your task is to return the maximum number of substrings formed, after possible partitions (probably zero) of s such that no two substrings have a common character.*/

class Solution {
    public int maxPartitions(String s) {
        HashMap<Character , Integer> lastIdx = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            lastIdx.put(s.charAt(i) , i);
        }
        int start = 0 , end = 0;
        for(int i = 0 ; i < s.length() ; i++){
            end = Math.max(end , lastIdx.get(s.charAt(i)));
            if(i == end){
                start++;
            }
        }
        return start;
    }
}
