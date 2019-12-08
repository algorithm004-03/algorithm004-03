/**
 * User: liwei
 * Date: 2019/10/18  12:23
 * Desc:
 */
public class LeetCode_21_338 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     *
     * 标签：链表、递归
     * 这道题可以使用递归实现，新链表也不需要构造新节点，我们下面列举递归三个要素
     * 终止条件：两条链表分别名为 l1 和 l2，当 l1 为空或 l2 为空时结束
     * 返回值：每一层调用都返回排序好的链表头
     * 本级递归内容：如果 l1 的 val 值更小，则将 l1.next 与排序好的链表头相接，l2 同理
     * O(m+n)，m 为 l1的长度，n 为 l2 的长度
     *
     * 解题关键是找到递归的规律，并且关注好递归的三要素即可，可通过最简单的链表验证，不用脑补所有递归过程
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l2.next, l1);
                return l2;
            }
        }
    }

    /**
     * 递归转迭代，需要自己手动实现重复操作部分
     * 时间复杂度：O(n + m)O(n+m) 。因为每次循环迭代中，l1 和 l2 只有一个元素会被放进合并链表中，
     * while 循环的次数等于两个链表的总长度。所有其他工作都是常数级别的，所以总的时间复杂度是线性的。
     * 空间复杂度：O(1)O(1) 。迭代的过程只会产生几个指针，所以它所需要的空间是常数级别的。
     * Link: https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/hua-jie-suan-fa-21-he-bing-liang-ge-you-xu-lian-bi/
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode prevHead = new ListNode(-1);

            ListNode prev = prevHead;  //哨兵节点可以减少很多特殊操作
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;  //此处容易遗漏
            }

            if (l1 == null) prev.next = l2;
            if (l2 == null) prev.next = l1;
//        prev.next = l1 == null ? l2 : l1;

            return prevHead.next;  //通过哨兵返回合并的表头
        }
    }
