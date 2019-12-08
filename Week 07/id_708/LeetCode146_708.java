class LRUCache {
    private class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;
        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public DLinkNode() {}

        @Override
        public String toString() {
            return "[key=" + key + ", value=" + value + ", prev=" + prev.key + ", next=" + next.key + "]";
        }
    }

    private void removeNode(DLinkNode node) {
        DLinkNode prev = node.prev;
        DLinkNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void addLast(DLinkNode node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void moveToLast(DLinkNode node) {
        removeNode(node);
        addLast(node);
    }

    private void removeFirst() {
        removeNode(head.next);
    }

    private Map<Integer, DLinkNode> cache;
    private DLinkNode head;
    private DLinkNode tail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        cache = new HashMap<>();
        // 使用两个哨兵节点，使插入删除操作不需要特殊处理
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkNode node = cache.getOrDefault(key, null);
        // System.out.println(node);
        if (node == null) return -1;
        moveToLast(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode newNode = new DLinkNode(key, value);
        DLinkNode oldNode = cache.getOrDefault(key, null);
        if (oldNode != null) {
            removeNode(oldNode);
            addLast(newNode);
            cache.put(key, newNode);
        } else {
            if (size == capacity) {
                cache.remove(head.next.key);
                removeFirst();
                size--;
            }
            addLast(newNode);
            // System.out.println(newNode);
            cache.put(key, newNode);
            size++;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */