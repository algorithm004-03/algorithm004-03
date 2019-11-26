
/**
 * leetcode 21题，合并两个有序链表
 *
 * @author northleaf
 * @create 2019年10月18日
 */
public class LeetCode_21_598 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 借助第三方LinkedList进行合并
     * 时间与空间复杂度均为0(n)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //定义一个带有虚拟头结的列表，返回时要返回它的next指针
        ListNode listNode = new ListNode(-1);
        ListNode h = listNode;
        //遍历两个链表
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                h.next = l1;
                l1 = l1.next;
            } else {
                h.next = l2;
                l2 = l2.next;
            }
            h = h.next;

        }
        //合并剩余的节点
        h.next = l1 == null ? l2 : l1;
        return listNode.next;
    }

}
