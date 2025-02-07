//Given a Binary Tree, your task is to return its In-Order Traversal.

//An inorder traversal first visits the left child (including its entire subtree), then visits the node, and finally visits the right child (including its entire subtree).


class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrderTraversal(root,result);
        return result;
    }
    
    void inOrderTraversal(Node node,ArrayList<Integer>result){
        if(node == null) return;
        
        inOrderTraversal(node.left,result);
        result.add(node.data);
        inOrderTraversal(node.right,result);
    }
}
