//Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.
class Solution {
    public int maxLen(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLength = 0;
        int sum = 0;
        for(int i = 0; i<arr.length ; i++)
        {
            sum += (arr[i] == 0) ? - 1 : 1;
            if(sum == 0) 
            {
                maxLength = i + 1;
            }
            if(map.containsKey(sum))
            {
                maxLength = Math.max(maxLength,i-map.get(sum));
            }
            else{
                map.put(sum,i);
            }
        }
        return maxLength;
    }
}
