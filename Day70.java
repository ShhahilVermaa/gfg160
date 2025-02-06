//Given two arrays representing the inorder and preorder traversals of a binary tree, construct the tree and return the root node of the constructed tree.Note: The output is written in postorder traversal.
class Solution {
    static int preIndex = 0;
    public static Node buildTree(int inorder[], int preorder[]) {
        preIndex = 0;
        Map<Integer,Integer>inMap = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++){
            inMap.put(inorder[i],i);
        }
        return constructTree(inorder , preorder , 0 ,inorder.length - 1 ,inMap);
    }
    
    private static Node constructTree(int inorder[] , int preorder[] , int inStart , int inEnd ,  Map<Integer,Integer>inMap){
        if(inStart > inEnd) return null;
        
        int rootValue = preorder[preIndex ++];
        Node root = new Node(rootValue);
        
        int intIndex = inMap.get(rootValue);
        
        root.left = constructTree(inorder , preorder ,  inStart , intIndex - 1 , inMap);
        root.right = constructTree(inorder , preorder , intIndex + 1 , inEnd , inMap);
        return root;
        
    }
 }

