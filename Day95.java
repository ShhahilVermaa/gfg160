/*Given an array of positive integers arr[] and a non-negative integer x, the task is to find the longest sub-array where the absolute difference between any two elements is not greater than x.
If multiple such subarrays exist, return the one that starts at the smallest index.*/
class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        TreeMap<Integer , Integer> freqMap = new TreeMap<>();
        int left = 0 , right = 0;
        int maxLen = 0 , startIdx = 0;
        
        while(right < arr.length){
            freqMap.put(arr[right] , freqMap.getOrDefault(arr[right] , 0) + 1);
            while(freqMap.lastKey() - freqMap.firstKey() > x){
                freqMap.put(arr[left] , freqMap.get(arr[left]) - 1);
                if(freqMap.get(arr[left]) == 0){
                    freqMap.remove(arr[left]);
                }
                left++;
            }
            if(right - left + 1 > maxLen){
                maxLen = right - left + 1;
                startIdx = left;
            }
            right++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = startIdx ; i < startIdx + maxLen ; i++){
            result.add(arr[i]);
        }
        return result;
    }
}
