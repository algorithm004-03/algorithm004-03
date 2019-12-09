/**
 * @program: leetcode
 * @description: Reverse Nodes in k-Group
 * @author: 王瑞全
 * @create: 2019-10-2020:19
 **/


public class leetcode25_1_468 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    //这道题没有理解后续还会学习。目前是贴了题解
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null||head.next==null||k<2) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode tail = dummy, prev = dummy,temp;
        int count;
        while(true){
            count =k;
            while(count>0&&tail!=null){
                count--;
                tail=tail.next;
            }
            if (tail==null) break;//Has reached the end


            head=prev.next;//for next cycle
            while(prev.next!=tail){
                temp=prev.next;//Assign
                prev.next=temp.next;//Delete

                temp.next=tail.next;
                tail.next=temp;//Insert

            }

            tail=head;
            prev=head;

        }
        return dummy.next;
    }
}
