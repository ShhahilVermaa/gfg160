//Given an unsorted array of integers, find the number of continuous subarrays having sum exactly equal to a given number k.//

class Solution {
    public int countSubarrays(int arr[], int k) 
    {
        int count=0;
        int cumulativeSum=0;
        Map<Integer,Integer> cumulativeSumCounts = new HashMap<>();
        cumulativeSumCounts.put(0,1);
        
        for(int num : arr)
        {
            cumulativeSum += num;
            
            if(cumulativeSumCounts.containsKey(cumulativeSum - k))
            {
                count += cumulativeSumCounts.get(cumulativeSum - k);
            }
            
            cumulativeSumCounts.put(cumulativeSum, cumulativeSumCounts.getOrDefault(cumulativeSum,0) + 1);
        }
        return count;
    }
}
