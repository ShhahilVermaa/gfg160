//Given the head of a singly linked list, your task is to left rotate the linked list k times.

class Solution {
    public Node rotate(Node head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
       Node tail = head;
       int n = 1;
       while(tail.next!=null)
       {
           tail = tail.next;
           n++;
       }
       tail.next = head;
       k = k%n;
       while(k > 0)
       {
           k--;
           tail = tail.next;
       }
       head = tail.next;
       tail.next = null;
       return head;
    }
}
