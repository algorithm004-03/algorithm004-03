/**
 * @program: leetcode
 * @description: Linked List Cycle
 * @author: 王瑞全
 * @create: 2019-10-2017:39
 **/


public class leetcode141_1_468 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
     //快慢指针问题龟兔赛跑
    public boolean hasCycle(ListNode head) {
         if(head==null){
             return false;
         }
         ListNode first=head;
         ListNode second=head;
         while(second.next!=null&&second.next.next!=null){
             first=first.next;
             second=second.next.next;
             if(first==second){
                 return true;
             }
         }
         return false;
    }

}
