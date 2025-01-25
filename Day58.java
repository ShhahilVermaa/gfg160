//Given a head of the singly linked list. If a loop is present in the list then return the first node of the loop else return NULL.


class Solution {
    public static Node findFirstNode(Node head) {
            Node slow = head;
            Node fast = head;
            while(fast != null && fast.next != null)
            {
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast) break;
            }
            if(fast == null || fast.next == null) return null;
            
            fast = head;
            
            while(slow != fast)
            {
                slow = slow.next;
                fast = fast.next;
            }
            
            return slow;
    }
}
