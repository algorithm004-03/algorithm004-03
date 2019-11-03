import practice.ListNode;

/**
 * @author: liuyanhui@daojia-inc.com
 * @date: 2019/10/22
 */
public class LeetCode_21_368 {
    /*将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    https://leetcode-cn.com/problems/merge-two-sorted-lists/*/

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l1.next = l12;
        l12.next = l13;
        l13.next = null;
        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(5);
        l2.next = l22;
        l22.next = l23;
        l23.next = null;

        ListNode pre = mergeTwoListsRecursion(l1, l2);
        while (pre != null) {
            System.out.println(pre.val);
            pre = pre.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 != null ? l1 : l2;
        return preHead.next;
    }

    public static ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursion(l1, l2.next);
            return l2;
        }
    }
}