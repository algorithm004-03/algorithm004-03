import java.util.Hashtable;
import java.util.LinkedHashMap;

/**
 * LRU缓存机制
 * @author L
 *	获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
	写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 */
public class LeetCode_146_138 {
	/**
	 * 借助linkedhashmap实现 有序字典
	 * @author L
	 *
	 */
	class LRUCache extends LinkedHashMap<Integer, Integer>{
		private int capacity;

		public LRUCache(int capacity) {
			super(capacity,0.75F,true);
			this.capacity = capacity;
		}
		
		public int get(int key) {
			return super.getOrDefault(key, -1);
		}
		
		public void put(int key,int value) {
			super.put(key, value);
		}
		
		/**
		 * 重写父类的删除方法
		 */
		@Override
		protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
			return size()>capacity;
		}
		
	}
	
	
//	/哈希表 + 双向链表
	public class LRUCache2 {

		  class DLinkedNode {
		    int key;
		    int value;
		    DLinkedNode prev;
		    DLinkedNode next;
		  }

		  private void addNode(DLinkedNode node) {
		    /**
		     * Always add the new node right after head.
		     */
		    node.prev = head;
		    node.next = head.next;

		    head.next.prev = node;
		    head.next = node;
		  }

		  private void removeNode(DLinkedNode node){
		    /**
		     * Remove an existing node from the linked list.
		     */
		    DLinkedNode prev = node.prev;
		    DLinkedNode next = node.next;

		    prev.next = next;
		    next.prev = prev;
		  }

		  private void moveToHead(DLinkedNode node){
		    /**
		     * Move certain node in between to the head.
		     */
		    removeNode(node);
		    addNode(node);
		  }

		  private DLinkedNode popTail() {
		    /**
		     * Pop the current tail.
		     */
		    DLinkedNode res = tail.prev;
		    removeNode(res);
		    return res;
		  }

		  private Hashtable<Integer, DLinkedNode> cache =
		          new Hashtable<Integer, DLinkedNode>();
		  private int size;
		  private int capacity;
		  private DLinkedNode head, tail;

		  public LRUCache2(int capacity) {
		    this.size = 0;
		    this.capacity = capacity;

		    head = new DLinkedNode();
		    // head.prev = null;

		    tail = new DLinkedNode();
		    // tail.next = null;

		    head.next = tail;
		    tail.prev = head;
		  }

		  public int get(int key) {
		    DLinkedNode node = cache.get(key);
		    if (node == null) return -1;

		    // move the accessed node to the head;
		    moveToHead(node);

		    return node.value;
		  }

		  public void put(int key, int value) {
		    DLinkedNode node = cache.get(key);

		    if(node == null) {
		      DLinkedNode newNode = new DLinkedNode();
		      newNode.key = key;
		      newNode.value = value;

		      cache.put(key, newNode);
		      addNode(newNode);

		      ++size;

		      if(size > capacity) {
		        // pop the tail
		        DLinkedNode tail = popTail();
		        cache.remove(tail.key);
		        --size;
		      }
		    } else {
		      // update the value.
		      node.value = value;
		      moveToHead(node);
		    }
		  }
		}

}
