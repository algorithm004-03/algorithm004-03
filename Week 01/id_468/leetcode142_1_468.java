/**
 * @program: leetcode
 * @description: Linked List Cycle II
 * @author: 王瑞全
 * @create: 2019-10-2017:56
 **/


public class leetcode142_1_468 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //快慢指针问题龟兔赛跑
    public ListNode hasCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode first=head;
        ListNode second=head;
        while(second.next!=null&&second.next.next!=null){
            first=first.next;
            second=second.next.next;
            if(first==second){
                while(head!=second){
                    head=head.next;
                    second=second.next;
                }
                return head;
            }
        }
        return null;
    }
}
