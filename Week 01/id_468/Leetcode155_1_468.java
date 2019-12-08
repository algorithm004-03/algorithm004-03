import javax.jws.WebParam;

/**
 * @program: leetcode
 * @description: minStack
 * @author: 王瑞全
 * @create: 2019-10-1820:00
 **/


public class Leetcode155_1_468 {
    class MinStack {
        private Node node;

        public MinStack() {
        }

        public void push(int x) {
            if(node==null){
                node=new Node(x,x);
            }else {
                node=new Node(x,Math.min(x,node.min),node);
            }
        }

        public void pop() {
            node=node.next;
        }

        public int top() {
            return node.val;
        }

        public int getMin() {
           return node.min;
        }
        private class Node{
            int val;
            int min;
            Node next;

            public Node(int val, int min) {
                this.val = val;
                this.min = min;
            }

            public Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }
    }

}
