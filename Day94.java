/*Given an array arr[] of integers and an integer k, your task is to find the maximum value for each contiguous subarray of size k. The output should be an array of maximum values corresponding to each contiguous subarray.*/
class Solution {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            while(!deque.isEmpty() && deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            
            if(i >= k - 1){
                result.add(arr[deque.peekFirst()]);
            }
        }
        return result;
    }
}
