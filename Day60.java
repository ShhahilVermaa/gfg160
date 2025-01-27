/*Design a data structure that works like a LRU Cache. Here cap denotes the capacity of the cache and Q denotes the number of queries. Query can be of two types:

PUT x y: sets the value of the key x with value y
GET x: gets the key of x if present else returns -1.
The LRUCache class has two methods get() and put() which are defined as follows.

get(key): returns the value of the key if it already exists in the cache otherwise returns -1.
put(key, value): if the key is already present, update its value. If not present, add the key-value pair to the cache. If the cache reaches its capacity it should remove the least recently used item before inserting the new item.
In the constructor of the class the capacity of the cache should be initialized.*/

class LRUCache {
    private final int capacity;
    private final Map<Integer,Node> cache;
    private final DoubleLL dll;
    
    // Constructor for initializing the cache capacity with the given value.
    public LRUCache(int cap) {
        this.capacity = cap;
        this.cache = new HashMap<>();
        this.dll = new DoubleLL();
    }

    // Function to return value corresponding to the key.
    public int get(int key) {
        if(!cache.containsKey(key)){
        return -1;
    }
        Node node = cache.get(key);
        dll.moveHead(node);
        return node.value;
    }

    // Function for storing key-value pair.
    public void put(int key, int value) {
        if(cache.containsKey(key))
        {
            Node node = cache.get(key);
            node.value = value;
            dll.moveHead(node);
        }
        else{
            if(cache.size() >= capacity)
            {
                Node tail = dll.removeTail();
                cache.remove(tail.key);
            }
            Node newNode = new Node(key,value);
            cache.put(key,newNode);
            dll.addHead(newNode);
        }
    }
}
class Node{
    int key,value;
    Node prev,next;
    
    public Node(int key,int value)
    {
        this.key = key;
        this.value = value;
    }
}
class DoubleLL{
    private final Node head;
    private final Node tail;
    
    public DoubleLL()
    {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    public void addHead(Node node)
    {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    public void moveHead(Node node)
    {
        removeNode(node);
        addHead(node);
    }
    public void removeNode(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public Node removeTail()
    {
        Node tailNode = tail.prev;
        removeNode(tailNode);
        return tailNode;
    }
}
