import java.util.HashMap;
import java.util.Map;

/**
 * @author northleaf
 * @create 2019年11月27日
 */
public class LeetCode_146_598 {
    class LRUCache {
        /**
         * 元素数量
         */
        int size = 0;

        /**
         * 容量所容纳元素上限
         */
        int capacity = 0 ;



        private class DLinkNode{
            int var;
            DLinkNode prev;
            DLinkNode next;

            public DLinkNode(int var) {
                this(var,null,null);
            }

            public DLinkNode(int var, DLinkNode prev, DLinkNode next) {
                this.var = var;
                this.prev = prev;
                this.next = next;
            }
        }
        /**
         * hashMap
         */
        Map<Integer,DLinkNode> map;

        /**
         * 头结点
         */
        DLinkNode head;

        /**
         * 尾结果
         */
        DLinkNode tail;


        public LRUCache(int capacity) {

            this.capacity = capacity;
            this.size = 0;
            //为了不让map扩容，直接设定它的初始容量
            this.map = new HashMap<>((capacity * 4)/3 + (capacity*4)%3);

            //头尾指针
            head = new DLinkNode(-1);
            tail = new DLinkNode(-1);
            head.next = tail;
            tail.prev = head;

        }


        public int get(int key) {

            DLinkNode node = map.get(key);
            //不为null
            if (node != null) {
                moveTohead(node);
                return node.var;
            }

            return -1;


        }


        public void put(int key, int value) {

            DLinkNode node = map.get(key);
            if (node != null) {
                node.var = value;
                moveTohead(node);
            }else{
                //添加元素
                node = new DLinkNode(value);
                map.put(key,node);
                addNode(node);
            }
        }

        /**
         * 移动到队道
         * @param node
         */
        private void moveTohead(DLinkNode node) {

            //第一步移除这个node
            removeNode(node);
            //第二步添加到队首
            addNode(node);

        }

        /**
         * 在队首添加元素
         * @param node
         */
        private void addNode(DLinkNode node) {
            if (node == null) {
                return;
            }

            node.next = head.next;
            head.next.prev = node;

            head.next = node;
            node.prev = head;


            size++;
            //判断要不要移动队尾
            removeLast();

        }

        /**
         * 移除队尾前的元素
         */
        private void removeLast() {

            if(size > capacity){
                DLinkNode node = tail.prev;
                removeNode(node);
                for(Integer key: map.keySet()){
                    if(map.get(key) == node){
                        map.remove(key);
                        return;
                    }
                }
            }

        }

        /**
         * 移除节点
         * @param node
         */
        private void removeNode(DLinkNode node) {
            if (node == null) {
                return;
            }
            DLinkNode pre = node.prev;
            DLinkNode next = node.next;

            pre.next = next;
            next.prev = pre;

            node.prev = null;
            node.next = null;

            size --;
            return;
        }

    }

}
