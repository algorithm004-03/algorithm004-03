package io.beansoft.pencil.leetcode;


/**
 * @author beanlam
 * @version 1.0
 * @date 2019-10-20 14:49
 */
public class LeetCode_21_263 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultHeeader = new ListNode(-1);
        ListNode tail = resultHeeader;

        ListNode header1 = new ListNode(-1);
        header1.next = l1;

        ListNode header2 = new ListNode(-1);
        header2.next = l2;

        ListNode next1 = header1.next;
        ListNode next2 = header2.next;

        while (true) {

            if (next1 == null) {
                while(next2 != null) {
                    tail.next = new ListNode(next2.val);
                    tail = tail.next;
                    next2 = next2.next;
                }
                break;
            }

            if (next2 == null) {
                while(next1 != null) {
                    tail.next = new ListNode(next1.val);
                    tail = tail.next;
                    next1 = next1.next;
                }
                break;
            }


            if (next1.val == next2.val) {
                tail.next = new ListNode(next2.val);
                tail = tail.next;
                tail.next = new ListNode(next1.val);
                tail = tail.next;

                next1 = next1.next;
                next2 = next2.next;
                continue;
            }

            if (next1.val < next2.val) {
                tail.next = new ListNode(next1.val);
                tail = tail.next;

                next1 = next1.next;
                continue;
            }

            if (next2.val < next1.val) {
                tail.next = new ListNode(next2.val);
                tail = tail.next;

                next2 = next2.next;
                continue;
            }
        }


        return resultHeeader.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
