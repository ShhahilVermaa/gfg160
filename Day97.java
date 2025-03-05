/*You are given an array of words where each word consists of lowercase English letters.
wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB. For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".

A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k = 1.

Return the length of the longest possible word chain with words chosen from the given list of words in any order.*/
class Solution {
    public int longestStringChain(String words[]) {
        Arrays.sort(words,(a,b) -> a.length() - b.length());
        
        HashMap<String,Integer> dp = new HashMap<>();
        int maxChainLength = 1;
        
        for(String word : words){
            int best = 1;
            for(int i = 0 ; i < word.length() ; i++)
            {
                String predecessor = word.substring(0,i) + word.substring(i+1);
                if(dp.containsKey(predecessor)){
                    best = Math.max(best , dp.get(predecessor) + 1);
                }
            }
            dp.put(word , best);
            maxChainLength = Math.max(maxChainLength , best);
        }
        return maxChainLength;
    }
}
