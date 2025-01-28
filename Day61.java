//Given a string s, which may contain duplicate characters, your task is to generate and return an array of all unique permutations of the string. You can return your answer in any order.
class Solution {
    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        backtrack(result,new StringBuilder(),chars,new boolean[chars.length],0);
        return result;
    }
    private static void backtrack(ArrayList<String>result,StringBuilder current,char[]chars,boolean[]used,int depth)
    {
        if(depth == chars.length)
        {
            result.add(current.toString());
            return;
        }
        for(int i = 0 ; i < chars.length ; i++)
        {
            if(used[i] || (i > 0 && chars[i] == chars[i-1] && !used[i-1]))
            {
                continue;
            }
            used[i] = true;
            current.append(chars[i]);
            backtrack(result,current,chars,used,depth+1);
            current.setLength(current.length()-1);
            used[i] = false;
        }
    }
}
