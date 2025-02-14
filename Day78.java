//Given the root of a Binary search tree(BST), where exactly two nodes were swapped by mistake. Your task is to fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
class Solution {
    Node first , middle , last , prev;
    void correctBSTUtil(Node root) {
        if(root == null) return;
        correctBSTUtil(root.left);
        
        if(prev != null && root.data < prev.data){
            if(first == null){
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }  
        prev = root;
        correctBSTUtil(root.right);
    }
    void correctBST(Node root){
        first = middle = last = prev = null;
        correctBSTUtil(root);
        
        if(first != null && last != null){
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }else if(first != null && middle != null){
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }
}
