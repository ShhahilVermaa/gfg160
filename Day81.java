//Given an array arr[] of positive integers and an integer k, Your task is to return k largest elements in decreasing order.
class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i = 0 ; i < k ; i++){
            minHeap.add(arr[i]);
        }
        for(int i = k ; i < arr.length ; i++){
            if(arr[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!minHeap.isEmpty()){
            result.add(minHeap.poll());
        }
        Collections.reverse(result);
        return result;
    }
}
