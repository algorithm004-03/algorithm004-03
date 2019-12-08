import java.util.Hashtable;

/**
 * LRU缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class LeetCode_146_588 {

    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    // 插入节点（将节点插在head标兵的后面）
    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    // 删除某个节点
    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    // 将某个节点移动到前面
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    // 删除最后一个节点（即tail标兵前面一个节点）
    private DLinkedNode popTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public LeetCode_146_588(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // 先判断是否在hashtable中存在
        DLinkedNode node = cache.get(key);
        if (null == node) {
            return -1;
        }

        // 将节点移动到最前面
        moveToHead(node);

        return node.value;
    }


    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        // 如果hashTable没找到相应元素，则插入
        if (null == node) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            size ++;

            // 如果缓存已满，则移除最后的节点
            if (size > capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                size --;
            }
        } else {
            // 如果找到了，则将其移动到最前面
            node.value = value;
            moveToHead(node);
        }
    }
}
