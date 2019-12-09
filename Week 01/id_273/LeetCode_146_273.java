//146 LRU缓存

//解法1，通过链表作为缓存容器，HashMap作为链表节点位置的映射，使其随机访问时间复杂度为O(1)
class LRUCache {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private LinkedList<Integer> list = new LinkedList<>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    
    public int get(int key) {
        //若map存在对应映射
        if(map.containsKey(key)){
            //需要将其放置在list首部 表示最近使用
            list.remove((Integer)key);
            list.addFirst(key);
            return map.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        //若put时 检测到key已经存在 则在链表中移除对应的node
        if(map.containsKey(key)){
            list.remove((Integer)key);
        //若不存在
        } else {
            //若此时缓存已满 则在链表中移除末尾node
            if(list.size() == capacity){
                map.remove(list.removeLast());
            }
        }
        //链表头添加 表示最近使用的
        list.addFirst(key);
        //map添加list映射
        map.put(key,value);
    }
}