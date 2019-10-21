package com.github.kylefeng.week01;

import org.junit.jupiter.api.Test;

import static com.github.kylefeng.week01.LeetCode_641_038.MyCircularDeque;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kylefeng
 * @time 2019/10/19 10:56
 */
public class LeetCode_641_038_Test {

    @Test
    void test_circular_dequeue_with_maximum_size_3() {
        MyCircularDeque deque = new MyCircularDeque(3);
        assertTrue(deque.insertLast(1));
        assertTrue(deque.insertLast(2));
        assertTrue(deque.insertFront(3));
        assertFalse(deque.insertFront(4));
        assertEquals(2, deque.getRear());
        assertTrue(deque.isFull());
        assertTrue(deque.deleteLast());
        assertTrue(deque.insertFront(4));
        assertEquals(4, deque.getFront());
    }
}
