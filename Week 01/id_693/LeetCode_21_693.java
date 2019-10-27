package id_693;

/**
 * @Desc 21.合并两个有序链表 https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/14
 */
public class LeetCode_21_693 {
    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode r = head;
        while (l1 != null && l2 != null) {
            boolean is = l1.val < l2.val;
            head.next = is ? l1 : l2;
            l1 = is ? l1.next : l1;
            l2 = is ? l2 : l2.next;
            head = head.next;
        }
        head.next = l1 == null ? l2 : l1;
        return r.next;
    }
}
