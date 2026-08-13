class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    LRUCache(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();

        // Dummy nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Remove a node from wherever it currently is
    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add a node at MRU position
    void addToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // It was just used → make it MRU
        remove(node);
        addToTail(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {
            Node node = map.get(key);

            node.value = value;

            // Updated → make it MRU
            remove(node);
            addToTail(node);

            return;
        }

        // New key
        Node node = new Node(key, value);

        map.put(key, node);
        addToTail(node);

        // Capacity exceeded
        if (map.size() > capacity) {
            Node lru = head.next;

            remove(lru);
            map.remove(lru.key);
        }
    }
}