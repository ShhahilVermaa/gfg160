//You are given the head of a singly linked list. Your task is to determine if the linked list contains a loop. A loop exists in a linked list if the next pointer of the last node points to any other node in the list (including itself), rather than being null.

class Solution {
    public static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow ==  fast) return true;
        }
        return false;
    }
}
