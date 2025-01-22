//Given the head of two singly linked lists num1 and num2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.

For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.
class Solution {
    public static Node reverse(Node head)
    {
        Node prev=null,curr=head,next=null;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        while(num1!=null && num1.data==0)
        {
            num1 = num1.next;
        }
        while(num2!=null && num2.data == 0)
        {
            num2 = num2.next;
        }
        if(num1==null) return num2;
        if(num2==null) return num1;
        
        num1=reverse(num1);
        num2=reverse(num2);
        Node temp = new Node(-1),ans=temp;
        int carry=0;
        
        while(num1!=null||num2!=null||carry!=0)
        {
            int sum = carry;
            if(num1!=null)
            {
                sum+=num1.data;
                num1=num1.next;
            }
            if(num2!=null)
            {
                sum+=num2.data;
                num2=num2.next;
            }
            carry = sum/10;
            temp.next=new Node(sum%10);
            temp=temp.next;
        }
        return reverse(ans.next);
    }
}
