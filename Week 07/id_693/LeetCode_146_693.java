package id_693;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author 李雷（KyLin）
 * @Desc 146. LRU缓存机制 https://leetcode-cn.com/problems/lru-cache/
 * @Date 2019/11/27
 */
public class LeetCode_146_693 {
    /**
     * LinkedHashMap + 重写removeEldestEntry
     */
    public class LRUCache {
        LinkedHashMap<Integer, Integer> elements;

        public LRUCache(int capacity) {
            //考虑已经限定了容量，所以直接设定加载因子(负荷因子)为1
            this.elements = new LinkedHashMap<Integer, Integer>(capacity,1,true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > capacity;
                }
            };

        }

        public int get(int key) {
            Integer e = elements.get(key);
            return e == null ? -1 : e;
        }

        public void put(int key,int value) {
            elements.put(key,value);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LeetCode_146_693().new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);

    }

    /**
     * 双向链表 + HashMap
     */
    public class LRUCache2 {
        LinkedList<Integer> order;
        Map<Integer, Integer> elements;
        int size;
        int capacity;

        public LRUCache2(int capacity) {
            this.order = new LinkedList<>();
            this.elements = new HashMap<>(capacity,1);
            this.capacity = capacity;
            this.size = 0;
        }

        public int get(int key) {
            if (!elements.containsKey(key)) {
                return -1;
            } else {
                order.addFirst(order.remove(order.indexOf(key)));
                return elements.get(key);
            }
        }

        public void put(int key,int value) {
            if (elements.containsKey(key)) {
                order.addFirst(order.remove(order.indexOf(key)));
                elements.put(key,value);
            } else {
                if (size == capacity) {
                    int t = order.removeLast();
                    elements.remove(t);
                } else {
                    size++;
                }
                order.addFirst(key);
                elements.put(key,value);
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
