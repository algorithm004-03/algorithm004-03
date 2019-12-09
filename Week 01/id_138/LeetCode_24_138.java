/**
 * 两两交换链表中的相邻节点
 * @author Lukas
 * @since 2019/10/19 20:10
 **/
public class LeetCode_24_138 {

    /**
     * 递归调用方式
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;//下一个节点指针
        head.next = swapPairs(next.next);//递归调用
        next.next = head;//交换
        return next;
    }

    /**
     * 非递归调用方式
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode first = new ListNode(0);
        first.next = head;//重新设置需要交换的链表的头节点
        ListNode pre = first;//前一个遍历的节点
        ListNode cur = pre.next;//当前遍历的节点
        while (cur != null && cur.next != null) {
            ListNode temp = cur.next;//当前遍历节点的下个节点
            ListNode next = temp.next;//下次流程交换的节点
            pre.next = temp;//设置已经完成遍历的节点的next
            temp.next = cur;//交换节点

            //重新开始下一轮的交换
            pre = cur;
            cur = next;
        }

        return first.next;
    }

}
