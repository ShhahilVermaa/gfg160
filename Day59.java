//Given the head of a linked list that may contain a loop.  A loop means that the last node of the linked list is connected back to a node in the same list. The task is to remove the loop from the linked list (if it exists).

class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast !=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next ==null) return;
        slow = head;
        while(slow!=fast)
        {
            slow=slow.next;
            fast=fast.next;
        }
        while(slow.next!=fast)
        {
            slow = slow.next;
        }
        slow.next = null;
    }
}
