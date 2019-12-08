import java.util.HashMap;

/**
 * LRU Cache
 *
 * 执行用时 : * 31 ms * , 在所有 java 提交中击败了 * 86.81% * 的用户
 * 内存消耗 : * 59 MB * , 在所有 java 提交中击败了 * 90.57% * 的用户
 */
public class LRUCache {

  class LRUNode {
    int key;
    int value;
    LRUNode prev;
    LRUNode next;
  }

  private LRUNode head;
  private LRUNode tail;
  private int capcity;

  private HashMap<Integer, LRUNode> cache;

  public LRUCache(int capacity) {
    this.capcity = capacity;

    // 哨兵
    this.head = new LRUNode();
    this.head.prev = null;
    this.tail = new LRUNode();
    this.tail.next = null;

    this.head.next = this.tail;
    this.tail.prev = this.head;

    cache = new HashMap<>();
  }

  private void addNode(LRUNode node) {
    node.prev = head;
    node.next = head.next;

    head.next.prev = node;
    head.next = node;
  }

  private void removeNode(LRUNode node) {
    LRUNode prev = node.prev;
    LRUNode next = node.next;

    prev.next = node.next;
    next.prev = node.prev;
  }

  private void moveToHead(LRUNode node) {
    removeNode(node);
    addNode(node);
  }

  private LRUNode popTail() {
    LRUNode node = tail.prev;
    removeNode(node);

    return node;
  }

  // get value from map
  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }

    LRUNode node = cache.get(key);
    moveToHead(node);
    return node.value;
  }

  public void put(int key, int value) {
    LRUNode node = cache.get(key);
    if (node == null) {
      if (cache.size() >= capcity) {
        LRUNode n = popTail();
        cache.remove(n.key);
      }

      LRUNode newNode = new LRUNode();
      newNode.key = key;
      newNode.value = value;
      addNode(newNode);
      cache.put(key, newNode);
    } else {
      node.value = value;
      moveToHead(node);
    }
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(2));       // 返回2
    System.out.println(cache.get(1));       // 返回  1
    cache.put(3, 3);    // 该操作会使得密钥 2 作废
    System.out.println(cache.get(2));       // 返回 -1 (未找到)
    cache.put(4, 4);    // 该操作会使得密钥 1 作废
    System.out.println(cache.get(1));       // 返回 -1 (未找到)
    System.out.println(cache.get(3));       // 返回  3
    System.out.println(cache.get(4));       // 返回  4
  }
}
