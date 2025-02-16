/*Serialization is to store a tree in an array so that it can be later restored and deserialization is reading tree back from the array. Complete the functions

serialize() : stores the tree into an array a and returns the array.
deSerialize() : deserializes the array to the tree and returns the root of the tree.
Note: Multiple nodes can have the same data and the node values are always positive integers. Your code will be correct if the tree returned by deSerialize(serialize(input_tree)) is same as the input tree. Driver code will print the in-order traversal of the tree returned by deSerialize(serialize(input_tree)).
*/

class Tree {
    // Function to serialize a tree and return a list containing nodes of tree.
    public ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        serializeHelper(root,result);
        return result;
    }
    
    private void serializeHelper(Node root , ArrayList<Integer> result){
        if(root == null){
            result.add(-1);
            return;
        }
        result.add(root.data);
        serializeHelper(root.left,result);
        serializeHelper(root.right,result);
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        Index index = new Index();
        return deSerializeHelper(arr,index);
    }
    class Index{
        int index = 0;
    }
    
    private Node deSerializeHelper(ArrayList<Integer> arr , Index index){
        if(index.index >= arr.size() || arr.get(index.index) == -1){
            index.index++;
            return null;
        }
        Node root = new Node(arr.get(index.index));
        index.index++;
        
        root.left = deSerializeHelper(arr,index);
        root.right = deSerializeHelper(arr,index);
        
        return root;
    }
}
