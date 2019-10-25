package id_693.practise;

import id_693.ListNode;

/**
 * @Desc 206. 反转链表 https://leetcode-cn.com/problems/reverse-linked-list/submissions/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/17
 */
public class LeetCode_206_693 {
    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    //递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }
}
