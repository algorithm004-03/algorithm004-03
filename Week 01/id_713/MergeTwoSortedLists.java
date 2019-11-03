package id_713;

/**
 * 合并两个有序链表
 * Leetcode题号: 21
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    /*
    整体思路:
    1. 前置需要
        1. 定义带头节点, 常用于 链表的删除和修改, 以及输出结果时返回带头结点的后继即可
        2. 带头节点的指针, 用于作为要合并的节点的前驱
        3. 2个链表各自的指针
    2. 比较
        2个链表中, 哪个链表的值小, 作为带头指针的后继
    3. 循环跳出条件
        2个链表指针, 哪个先到NULL, 也就是哪个先遍历完毕, 就跳出来
    4. 补偿机制
        可能出现, 2个链表长度不一样的情况, 需要没有遍历完的链表作为合并后的后继
    */


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0), p0 = dummy, p1 = l1, p2 = l2; // 定义带头节点, 带头指针, 2个链表各自的指针

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) { // 当链表1的指针的值更小, 将作为带头指针的后继
                p0.next = p1;
                p1 = p1.next; // 链表1的指针向后移动
            } else {
                p0.next = p2;
                p2 = p2.next;
            }

            p0 = p0.next; // 带头指针向后移动
        }

        p0.next = (p1 == null ? p2 : p1); // 谁还没有遍历完, 作为带头指针的后继

        return dummy.next;
    }


    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}


