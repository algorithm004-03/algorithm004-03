package id_693.practise;

import id_693.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Desc 142. 环形链表 II	https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/04
 */
public class LeetCode_142_693 {
    //暴力解（哈希表），使用Set去重
    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    //双指针:双指针找环点，这时候需要返回环点的上一个指针，那么让其中一个到开头，另外一个在环点，同时逐步出发，最后在一起的就是环点前一个点。
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
