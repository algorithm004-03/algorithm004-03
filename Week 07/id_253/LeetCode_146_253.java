import java.util.Hashtable;
class LRUCache {
    class DLinkedNode{
        int key;
        int value ;
        DLinkedNode prev;
        DLinkedNode next;
    }
    private void addNode(DLinkedNode node ){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    private void removeNode(DLinkedNode node ){
        DLinkedNode next = node.next;
        DLinkedNode prev = node.prev;
        node.prev.next = next;
        node.next.prev = prev;
    }
    private void moveToHead(DLinkedNode node ){
        removeNode(node);
        addNode(node);
    }
    private DLinkedNode popTail(){
        DLinkedNode node = tail.prev;
        removeNode(tail.prev);
        return node;
    }
    private Hashtable<Integer , DLinkedNode> cache= new Hashtable<>();
    private int size;
    private int capacity;
    private DLinkedNode head , tail;
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null ) return -1;
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            DLinkedNode newnode = new DLinkedNode();
            newnode.value = value ;
            newnode.key = key ;
            cache.put(key,newnode);
            addNode(newnode);
            size++;
            if(size > capacity){
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                size -- ;
            }
        }else{
            node.value = value ;
            moveToHead(node);
        }
    }
}
