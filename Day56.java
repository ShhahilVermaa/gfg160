//You are given a special linked list with n nodes where each node has two pointers a next pointer that points to the next node of the singly linked list, and a random pointer that points to the random node of the linked list.

//Construct a copy of this linked list. The copy should consist of the same number of new nodes, where each new node has the value corresponding to its original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list, such that it also represent the same list state. None of the pointers in the new list should point to nodes in the original list.

//Return the head of the copied linked list.
class Solution {
    public Node cloneLinkedList(Node head) {
        // code here
        if(head==null) return null;
        
        Node current = head;
        while(current!=null)
        {
            Node newNode = new Node(current.data);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }
        
        current = head;
        while(current!=null)
        {
            if(current.random!=null) current.next.random = current.random.next;
            current = current.next.next;
        }
        
        Node original = head;
        Node copy = head.next;
        Node copyHead = copy;
        
        while(original!=null)
        {
            original.next = original.next.next;
            if(copy.next!=null) copy.next = copy.next.next;
            
            original = original.next;
            copy = copy.next;
        }
        return copyHead;
    }
}
