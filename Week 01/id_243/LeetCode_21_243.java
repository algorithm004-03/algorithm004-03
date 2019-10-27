/**
 * @author eazonshaw
 * @date 2019/10/20  15:16
 * 题目：21. 合并两个有序链表
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 描述：将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 */
public class LeetCode_21_243 {

    /**
     * 递归
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
