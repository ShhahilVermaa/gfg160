//Given an array of strings, return all groups of strings that are anagrams. The strings in each group must be arranged in the order of their appearance in the original array. Refer to the sample case for clarification.//
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        Map<String,ArrayList<String>>map=new HashMap<>();
        for(String str: arr)
        {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            
            map.putIfAbsent(sorted,new ArrayList<>());
            map.get(sorted).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}
