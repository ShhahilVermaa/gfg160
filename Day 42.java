//Given an array arr[] containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int start = 0;
        int currentsum = 0;
        
        for(int end = 0; end < arr.length ; end++)
        {
            currentsum+=arr[end];
            
            while(currentsum >  target&&start <= end)
            {
                currentsum -= arr[start];
                start++;
            }
            if(currentsum == target)
            {
                ArrayList<Integer>result = new ArrayList<>();
                result.add(start+1);
                result.add(end+1);
                return result;
            }
        }
        ArrayList<Integer> notFound = new ArrayList<>();
        notFound.add(-1);
        return notFound;
    }
}
