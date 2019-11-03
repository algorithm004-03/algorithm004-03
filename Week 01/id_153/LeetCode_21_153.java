/**
 * LeetCode_21_153
 * 
 * @desc LeetCode 21 题 https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class LeetCode_21_153 {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    } else if (l1.val < l2.val) {
      l1.next = mergeTwoLists1(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists1(l1, l2.next);
      return l2;
    }
  }

  /**
   * 维护一个新的链表，定义一个指针用于每一次比较指向下一个元素
   * 
   * @param l1
   * @param l2
   * @return
   */
  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    ListNode prevhead = new ListNode(-1);
    ListNode prev = prevhead;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        // l1 小于等于 l2 的值，将 prev 指针指向 l1，把 l1 的后继结点指向 l1
        // 相当于 l1 往前挪一个元素
        prev.next = l1;
        l1 = l1.next;
      } else {
        // l1 大于 l2，将 prev 指针指向 l2，l2 的后继结点指向 l2
        prev.next = l2;
        l2 = l2.next;
      }
      // 指针 prev 向前走一次，开始下一次的比较
      prev = prev.next;
    }
    // 判断 l1 是否为空，将非空链表合并的链表尾部
    prev.next = l1 == null ? l2 : l1;
    return prevhead.next;
  }
}