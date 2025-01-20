//Given the head of two sorted linked lists consisting of nodes respectively. The task is to merge both lists and return the head of the sorted merged list.
class Solution {
    Node sortedMerge(Node head1, Node head2) {
        if(head1==null) return head2;
        if(head2==null) return head1;
        
        Node dummy = new Node(0);
        Node current = dummy;
        
        while(head1!=null && head2!=null)
        {
            if(head1.data <= head2.data)
            {
                current.next=head1;
                head1=head1.next;
            }
            else{
                current.next=head2;
                head2=head2.next;
            }
            current=current.next;
        }
        if(head1!=null){
            current.next = head1;
        }
        else{
            current.next = head2;
        }
        
        return dummy.next;
    }
}
