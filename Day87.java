/*Given an array arr[ ] of integers, the task is to find the next greater element for each element of the array in order of their appearance in the array. Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1.*/

class Solution {
    
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n,-1));
        Stack<Integer> stack = new Stack<>();
        
        for(int i = n-1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result.set(i , stack.peek());
            }
            stack.push(arr[i]);
        }
        return result;
    }
}
