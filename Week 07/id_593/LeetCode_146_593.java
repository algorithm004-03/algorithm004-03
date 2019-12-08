import java.util.Hashtable;

/**
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 示例:
 * <p>
 * LRUCache cache = new LRUCache( 2 (缓存容量) );
 * <p>
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jaryoung
 */
class LRUCache {

    private DLinkedNode head;
    private DLinkedNode tail;

    class DLinkedNode {
        int key;
        int value;
        private DLinkedNode pre;
        private DLinkedNode next;
    }

    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;

        pre.next = next;
        next.pre = pre;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }

    private int capacity;
    private int size;
    private Hashtable<Integer, DLinkedNode> cache;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new Hashtable<>(capacity);
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DLinkedNode();
            node.value = value;
            // 1 bug
            node.key = key;
            cache.put(key, node);
            size++;
            if (size > capacity) {
                DLinkedNode tailNode = popTail();
                cache.remove(tailNode.key);
                size--;
            }
            addNode(node);
        } else {
            // 2 bug
            node.value = value;
            moveToHead(node);
        }
    }
}
