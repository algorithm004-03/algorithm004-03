/**
 * @program: leetcode
 * @description: Reverse Linked List
 * @author: 王瑞全
 * @create: 2019-10-2016:30
 **/


public class leetcode206_1_468 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
          ListNode newHead=head.next;
          ListNode newNode=reverseList(newHead);
          newHead.next=head;
          head.next=null;
          return newNode;
    }
}
