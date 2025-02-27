/*Given q queries, You task is to implement the following four functions for a stack:

push(x) – Insert an integer x onto the stack.
pop() – Remove the top element from the stack.
peek() - Return the top element from the stack. If the stack is empty, return -1.
getMin() – Retrieve the minimum element from the stack in O(1) time. If the stack is empty, return -1.
Each query can be one of the following:

1 x : Push x onto the stack.
2 : Pop the top element from the stack.
3: Return the top element from the stack. If the stack is empty, return -1.
4: Return the minimum element from the stack.
*/
class Solution {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public Solution() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Add an element to the top of Stack
    public void push(int x) {
        // code here
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }

    // Remove the top element from the Stack
    public void pop() {
        // code here
        if(!stack.isEmpty()){
            int removed = stack.pop();
            if(removed == minStack.peek()){
                minStack.pop();
            }
        }
    }

    // Returns top element of the Stack
    public int peek() {
        // code here
        return stack.isEmpty() ? -1 : stack.peek();
    }

    // Finds minimum element of Stack
    public int getMin() {
        // code here
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}
