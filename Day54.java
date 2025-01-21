//Given the head a linked list, the task is to reverse every k node in the linked list. If the number of nodes is not a multiple of k then the left-out nodes in the end, should be considered as a group and must be reversed.
class Solution {
    public static Node reverseKGroup(Node head, int k) {
        if(head == null || k <= 1) return head;
        
        Node curr = head;
        Node newHead = null;
        Node tail = null;
        while(curr!=null)
        {
            Node groupPrev=null,groupcurr=curr;
            int count = 0;
        
        while(curr!=null && count<k)
        {
            Node next = curr.next;
            curr.next = groupPrev;
            groupPrev = curr;
            curr = next;
            count++;
        }
        if(newHead == null) newHead = groupPrev;
        if(tail!=null) tail.next=groupPrev;
        tail = groupcurr;
        }
        return newHead;
    }
}
