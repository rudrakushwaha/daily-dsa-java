class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class LRUCache {

    int capacity = 0;
    HashMap<Integer,Node> map = new HashMap<>();

    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;


        //dummy nodes
        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.next = tail;
        tail.prev = head;
    }

     // Add node immediately after head
    // This makes it the MRU
    private void addToHead(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Remove node from wherever it currently is
    private void removeNode(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {

        if(map.size() == 0)
            return -1;
        
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);

        //moving node to mru
        //disconnecting
        node.prev.next = node.next;
        node.next.prev = node.prev;

        // adding to front
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

        // // Move this node to MRU
        // removeNode(node);
        // addToHead(node);
        

        return node.val;
        
    }
    
    public void put(int key, int value) {

        // key already exists
        if(map.containsKey(key)){

            Node node = map.get(key);
            // Update value
            node.val = value;

            //move to mru
            removeNode(node);
            addToHead(node);

            return;
        }

        // Create new node
        Node node = new Node(key, value);

        // Add to HashMap
        map.put(key, node);

        // Add to MRU position
        addToHead(node);

         // Capacity exceeded
        if (map.size() > capacity) {

            // LRU node
            Node lru = tail.prev;

            // Remove from linked list
            removeNode(lru);

            // Remove from HashMap
            map.remove(lru.key);
        }
        

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */