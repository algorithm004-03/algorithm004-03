package com.hand.week1.class3;

/**
 * @description:LeetCode21. 合并两个有序链表
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/10/16
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode current = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                current.next = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                l1 = l1.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        return listNode.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
