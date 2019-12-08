package com.test.leetcode.week07;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;



public class SolutionLru146 {


    @Test
    public void test1() {
        LRUCache cache = new LRUCache( 2  );/* 缓存容量 */

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }




}

class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int MAX_CACHE_SIZE;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.MAX_CACHE_SIZE = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_CACHE_SIZE;
    }
}

class LRUCache3 {
    private LinkedHashMap<Integer, Integer> map;
    private int MAX_CACHE_SIZE;
    private final float LOAD_FACTOR = 0.75f;

    public LRUCache3 (int capacity) {
        MAX_CACHE_SIZE = capacity;
        map = new LinkedHashMap(capacity, LOAD_FACTOR, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };
    }

    public int get(int key) {
        Integer val = map.get(key);
        return val == null ? -1 : val;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}

class LRUCache2 {

    private Map<Integer, Node> map; // key 和 node
    private DoubleList doubleList;
    private int MAX_CACHE_SIZE;

    public LRUCache2(int capacity) {
        MAX_CACHE_SIZE = capacity;
        map = new HashMap<>();
        doubleList = new DoubleList();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            doubleList.remove(node);
            doubleList.addFirst(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node cur = new Node(key, value);
        if (map.containsKey(cur.key)) {
            doubleList.remove(map.get(cur.key));
            doubleList.addFirst(cur);
            map.put(key, cur);
        } else {
            if (doubleList.getSize() == MAX_CACHE_SIZE) {
                Node last = doubleList.removeLast();
                map.remove(last.key);
            }
            doubleList.addFirst(cur);
            map.put(key, cur);
        }
    }
}

class Node {
    public int key, val;
    public Node pre, next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoubleList {
    private Node head, tail;
    private int size;

    public DoubleList () {
        this.head = new Node(0,0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }
    // 头部添加
    public void addFirst(Node node) {
        Node next = head.next;
        node.next = next;
        next.pre = node;
        node.pre = head;
        head.next = node;
        size ++;
    }
    // 尾部删除
    public Node removeLast() {
        Node last = tail.pre;
        if (last == head) {
            return null;
        }
        remove(last);
        return last;
    }

    public void remove(Node node) {
        Node nextNode = node.next;
        Node preNode = node.pre;
        preNode.next = node.next;
        nextNode.pre = node.pre;
        size --;
    }
    public int getSize() {
        return this.size;
    }
}

