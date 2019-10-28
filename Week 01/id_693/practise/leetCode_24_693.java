package id_693.practise;

import id_693.ListNode;

/**
 * @Author 李雷（KyLin）
 * @Desc 24. 两两交换链表中的节点  https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @Date 2019/10/21
 */
public class leetCode_24_693 {

    //使用递归的方式实现
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    //循环方式实现
    public ListNode swapPairs2(ListNode head) {

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode result = pre;
        while (result.next != null && result.next.next != null) {
            ListNode temp1 = result.next;//缓存第一个节点的地址 1
            ListNode temp2 = result.next.next.next;//缓存下一个头节点的地址 3

            result.next = result.next.next; //把第二个节点转变为第一个节点。
            result.next.next = temp1;//原来的第一个节点转变为第二个节点
            temp1.next = temp2;//把原来第三各节点放在temp1下面(temp现在时第二个节点)
            result = temp1;
        }
        return pre.next;
    }

    public static void main(String[] args) {


    }
}
