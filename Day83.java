/*Given an array arr[] of n sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list, then return the head of the merged linked list.*/
class Solution {
    
    Node mergeKLists(List<Node> arr) {
        if(arr == null || arr.isEmpty()){
            return null;
        }
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b) -> a.data - b.data);
        
        for(Node node : arr){
            if(node!=null){
                minHeap.add(node);
            }
        }
        Node dummy = new Node(-1);
        Node tail = dummy;
        
        while(!minHeap.isEmpty()){
            Node minNode = minHeap.poll();
            tail.next = minNode;
            tail = tail.next;
            
            if(minNode.next!=null){
                minHeap.add(minNode.next);
            }
        }
        return dummy.next;
    }
    void printList(Node head){
        while(head != null){
            System.out.println(head.data + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}
