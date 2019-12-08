package id_693.practise;

import id_693.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Desc 141 环形链表   https://leetcode-cn.com/problems/linked-list-cycle/submissions/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/16
 */
public class LeetCode_141_693 {
    //暴力求解，用hash或者set
    public boolean hasCycle(ListNode head) {
        Set<ListNode> a = new HashSet<>();
        while (head != null) {
            if (a.contains(head)) {
                return true;
            }
            a.add(head);
            head = head.next;
        }
        return false;
    }

    //进阶，快慢指针
    /*
    题解：
    1、如果快指针后面为null  那么说明不是环形
    2、如果当slow == fast 说明是环形
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
