package leetcode.week1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author eason.feng at 2019/10/20/0020 20:03
 **/
public class DequeNewMethodUseageExample {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        deque.add("eason");
        deque.addFirst("easaon_frist");
        deque.addLast("eason_last");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        str = deque.peekFirst();
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);
        PriorityQueue<String> priorityQueue;
    }
}
