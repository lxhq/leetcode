class Node {
    public int key;
    public int value;
    public Node pre;
    public Node next;
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    HashMap<Integer, Node> map;
    int count;
    int capacity;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
        count = 0;
    }
    
    public void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    public void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }
    
    public int get(int key) {
        int result = -1;
        if(map.get(key) != null) {
            Node node = map.get(key);
            result = node.value;
            deleteNode(node);
            addToHead(node);
        }
        return result;
    }
    
    public void put(int key, int value) {
        if(map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */