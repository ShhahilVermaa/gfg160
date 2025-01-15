//Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.
class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer,Integer>mp = new HashMap<>();
        int pre = 0;
        int ans = 0;
        for(int i = 0; i < arr.length ; i++)
        {
            pre += arr[i];
            if(pre == k)
            {
                ans = i+1;
            }
            else if(mp.containsKey(pre-k))
            {
                ans = Math.max(ans , i - mp.get(pre-k));
            }
            if(!mp.containsKey(pre))
            {
                mp.put(pre ,i);
            }
        }
        return ans;
    }
}
