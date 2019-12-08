import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Date 2019/12/1
 **/
public class LeetCode_146_648 {
    private Map<Integer,Integer> map;
    class LinkedCappedHashMap<K,V> extends LinkedHashMap<K,V>
    {
       int maxCapacity;
        LinkedCappedHashMap(int capacityNum){
           super(16,0.75f,true);
           this.maxCapacity = capacityNum;
       }
       protected boolean removeEldestEntry(Map.Entry eldest){
            return size()>maxCapacity;
       }
    }

    public LeetCode_146_648(int capacity) {
        map = new LinkedCappedHashMap<>(capacity);
    }
    public int get(int key) {
        if(!map.containsKey(key)){return  -1;}
        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key,value);
    }
}
