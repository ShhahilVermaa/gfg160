//You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target. It is given that the elements of the arr[] are in sorted order.

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        Map<Integer,Integer> freqMap = new HashMap<>();
        int count = 0;
        for(int num : arr)
        {
            int complement = target - num;
            if(freqMap.containsKey(complement))
            {
                count += freqMap.get(complement);
            }
            freqMap.put(num,freqMap.getOrDefault(num,0) + 1);
        }
         return count;
    }
}
