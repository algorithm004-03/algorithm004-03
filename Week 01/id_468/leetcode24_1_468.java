/**
 * @program: leetcode
 * @description: Swap Nodes in Pairs
 * @author: 王瑞全
 * @create: 2019-10-2017:21
 **/


public class leetcode24_1_468 {
    //递归是解决链表问题的最好办法
    //1。分解问题成为一个节点的问题
    //2。利用递归保存信息
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode swapPairs(ListNode head) {
          if(head==null||head.next==null){
              return null;
          }
          ListNode second=head.next;
          ListNode third=second.next;

          second.next=head;
          head.next=swapPairs(third);
          return second;
    }
}
