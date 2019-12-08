//146. LRU缓存机制

//解法1：双端链表 + HashMap 	执行用时：32ms
//思路：采用双端链表+哈希表的数据结构, 保证了put、get方法的时间复杂度都为O(1)
//		put：涉及了链表的增、删操作, 双端链表数据结构保证了在链表头、尾部的增、删操作的时间复杂度为O(1)
//		get：涉及了链表的查找操作, 那么通过哈希表存储链表节点的key值, 这样就可以保证在获取指定节点的时间复杂度为O(1)
public class LRUCache {
    private HashMap<Integer, DLinkedList.Node> map;
    private DLinkedList cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new DLinkedList();
    }

    public int get(int key) {
        //if exit, get and update
        if (map.containsKey(key)) {
            DLinkedList.Node node = map.get(key);
            put(key, node.value);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        //if already exit -> update
        DLinkedList.Node x = new DLinkedList.Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            map.remove(key);
            cache.addFirst(x);
            map.put(key, x);
        } else {//add new
            //if capacity is not enough
            if (capacity <= cache.size()) {
                //delete oldest, add latest
                DLinkedList.Node node = cache.removeLast();
                map.remove(node.key);
            }
            cache.addFirst(x);
            map.put(key, x);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(2, 1);
        cache.put(2, 2);
        cache.get(2);       // 返回  1
        cache.put(1, 1);    // 该操作会使得密钥 2 作废
        cache.put(4, 1);    // 该操作会使得密钥 1 作废
        cache.get(2);       // 返回 -1 (未找到)
    }
}

class DLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    public void addFirst(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
        size++;
    }

    public Node remove(Node node) {
        Node nodePrev = node.prev;
        Node nodeNext = node.next;
        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;
        size--;
        return node;
    }

    public Node removeLast() {
        if (tail.prev == head) return null;
        Node node = remove(tail.prev);
        return node;
    }

    public int size() {
        return size;
    }

    static class Node {
        public int value;
        public int key;
        private Node prev;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}