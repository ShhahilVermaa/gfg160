/*Given an array of integers arr[], the task is to find the maximum of the minimum values for every possible window size in the array, where the window size ranges from 1 to arr.size().

More formally, for each window size k, determine the smallest element in all windows of size k, and then find the largest value among these minimums where 1<=k<=arr.size().

*/
class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n + 1];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0 ; i < n ;i ++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            } 
            left[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            } 
            right[i] = (stack.isEmpty()) ? n : stack.peek();
            stack.push(i);
        }
        for(int i = 0 ; i < n ; i++){
            int ws = right[i] - left[i] - 1;
            result[ws] = Math.max(result[ws] , arr[i]);
        }
        for(int i = n - 1 ; i >= 1 ; i--){
            if(result[i] < result[i + 1]){
                result[i] = result[i + 1];
            }
        }
        ArrayList<Integer> op = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++){
            op.add(result[i]);
        }
        return op;
    }
}
