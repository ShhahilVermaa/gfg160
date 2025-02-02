//Given a root of a binary tree with n nodes, the task is to find its level order traversal. Level order traversal of a tree is breadth-first traversal for the tree.

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
       if(root == null) return result;
       
       Queue<Node> queue = new LinkedList<>();
       queue.add(root);
       
       while(!queue.isEmpty()){
           int size = queue.size();
           ArrayList<Integer>level = new ArrayList<>();
           
           for(int i = 0 ; i < size ; i++){
               Node node = queue.poll();
               level.add(node.data);
               
               if(node.left!=null) queue.add(node.left);
               if(node.right!=null)queue.add(node.right);
           }
           result.add(level);
       }
       return result;
    }
}
