package com.weekwork;

/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */


//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}

public class MergeTwoLists {

    //Method 1 Explain：通过移动指针获取当前节点的下一个节点
    public ListNode mergeTwoListsFuncOne(ListNode l1, ListNode l2) {
        if (l1==null && l2!=null) {
            return  l2;
        }else if (l1!=null && l2==null) {
            return l1;
        }
        else {
            ListNode l1node=l1;
            ListNode l2node=l2;

            ListNode first=new ListNode(-1);
            ListNode cur=first;
            while (l1node!=null) {
                while (l2node!=null) {
                    if (l2node.val<=l1node.val) {
                        cur.next=l2node;
                        cur=l2node;
                        l2node=l2node.next;
                    }
                    else {
                        break;
                    }
                }
                cur.next=l1node;
                cur=l1node;
                l1node=l1node.next;
            }
            if (l2node!=null) {
                cur.next=l2node;
            }
            return first.next;
        }
    }

    //Method 2 Explain：递归获取最小节点
    public ListNode mergeTwoListsFuncTwo(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = mergeTwoListsFuncTwo(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoListsFuncTwo(l1, l2.next);
            return l2;
        }

    }
}



