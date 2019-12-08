/**
 * @program: leetcode
 * @description: Merge Two Sorted Lists
 * @author: 王瑞全
 * @create: 2019-10-2019:03
 **/


public class leetcode21_1_468 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node = new ListNode(0);
        ListNode pre = node;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;

            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre=pre.next;
        }
        pre.next= l1!=null?l1:l2;
        return node.next;
    }
}
