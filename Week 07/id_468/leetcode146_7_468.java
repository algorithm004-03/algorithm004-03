package week7;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 146. LRU缓存机制
 * @author: 王瑞全
 * @create: 2019-12-0122:15
 **/


public class leetcode146_7_468 {
    class LRUCache {
        private Map<Integer, Integer> KmapV;
        private Map<Integer, Integer> KmapTime;
        private int capacity;
        private int time;

        public LRUCache(int capacity) {
            KmapV = new HashMap<>(capacity);
            KmapTime = new HashMap<>(capacity);
            this.capacity = capacity;
            time = 0;
        }

        public int get(int key) {
            int value = KmapV.getOrDefault(key, -1);
            if(value != -1) {
                time++;
                KmapTime.put(key, time);
            }
            return value;
        }

        public void put(int key, int value) {
            time++;
            if(KmapV.size() == capacity && !KmapV.containsKey(key)) {
                int t = time;
                int lcu = 0;
                for(int k : KmapTime.keySet()) {
                    if(KmapTime.get(k) < t) {
                        t = KmapTime.get(k);
                        lcu = k;
                    }
                }
                KmapTime.remove(lcu);
                KmapV.remove(lcu);
            }
            KmapV.put(key, value);
            KmapTime.put(key, time);
        }
    }
}
