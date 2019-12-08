package com.github.kylefeng.week01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 21. 合并两个有序链表
 *
 * @author kylefeng
 * @time 2019/10/19 21:09
 */
public class LeetCode_21_038 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode newLinkedList(int... nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Nums to be used to init linked list cannot be empty!");
        }

        ListNode head = new ListNode(Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            if (head.next == null) {
                head.next = node;
            } else {
                ListNode next = head.next;
                head.next = node;
                node.next = next;
            }
        }
        return head.next;
    }

    public static List<Integer> linkedListToList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 != null && l2 == null) {
            return l1;
        }

        if (l1 == null && l2 != null) {
            return l2;
        }

        if (l1.next == null && l2.next == null) {
            if (l1.val > l2.val) {
                l2.next = l1;
                return l2;
            } else {
                l1.next = l2;
                return l1;
            }
        }

        List<Integer> list = new ArrayList();
        while (l1 != null) {
            list.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            list.add(l2.val);
            l2 = l2.next;
        }

        Collections.sort(list, (o1, o2) -> -(o1 - o2));

        ListNode head = new ListNode(Integer.MIN_VALUE);
        for (Integer n : list) {
            ListNode node = new ListNode(n);
            if (head.next == null) {
                head.next = node;
            } else {
                ListNode next = head.next;
                head.next = node;
                node.next = next;
            }
        }
        return head.next;
    }
}

