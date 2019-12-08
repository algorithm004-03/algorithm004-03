import java.util.LinkedHashMap;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 
 * @author gning (id=698)
 */

 public class LeetCode_146_698 extends LinkedHashMap<Integer,Integer> {

    private int capacity;

    public LeetCode_146_698(int cap) {
        super(cap,0.75F,true);
        this.capacity = cap;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);        
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }

 }