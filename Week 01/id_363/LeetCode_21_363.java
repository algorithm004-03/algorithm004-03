package com.test.leetcode;

import org.junit.Test;

import java.util.List;


public class SolutionMergeTwoList21 {


    @Test
    public void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        ListNode result = mergeTwoLists(node1, node4);
        System.out.println(result);
    }


    /**
     * 时间复杂度是O(n + m)
     * 空间复杂度也是O(n + m)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null && l2 != null) return l2;
        if (l2 == null && l1 != null) return l1;
        ListNode result = new ListNode(0);
        ListNode nowNode = result;
        while (l1 != null && l2 != null) {
            int min;
            while (l1 != null && l2 != null && l1.val < l2.val) {
                min = l1.val;
                l1 = l1.next;
                result.next = new ListNode(min);
                result = result.next;
            }
            while (l1 != null && l2 != null && l1.val > l2.val) {
                min = l2.val;
                l2 = l2.next;
                result.next = new ListNode(min);
                result = result.next;
            }
            while (l1 != null && l2 != null && l1.val == l2.val) {
                result.next = new ListNode(l1.val);
                result = result.next;
                result.next = new ListNode(l2.val);
                result = result.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            result.next = new ListNode(l1.val);
            result = result.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            result.next = new ListNode(l2.val);
            result = result.next;
            l2 = l2.next;
        }
        return nowNode.next;
    }

    /**
     * 递归解法：
     * 1.终止条件 l1 = null || l2 = null
     * 2.递归方程: 找两个聊表头的最小值，把最小值拼接到结果上，
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    /**
     * 链表题目： 1.遍历 2. 哨兵 3.原有节点尽可能的重复使用
     * 链表两种解题思路： 1. 循环 2. 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_xunhuan_best(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null)  return l2;
        if (l1 != null && l2 == null) return l1;
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (l1 != null &&  l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return preHead.next;
    }


}
