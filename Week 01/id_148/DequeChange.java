package com.ning.test;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 描述：
 *
 * @author yu.shao@okcoin.com
 * @create 2019-10-23 下午11:18
 */
public class DequeChange {

    @Test
    public void test() {
        Deque<String> deque = new LinkedList<>();

        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");

        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0) {
            System.out.println(deque.pop());
        }

        System.out.println(deque);


        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");

        System.out.println(deque);

        while(deque.size() > 0) {
            System.out.println(deque.poll());
        }
    }
}
