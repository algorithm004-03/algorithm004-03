//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
//示例： 
//
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
//Related Topics 链表



//leetcode submit region begin(Prohibit modification and deletion)
/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) { val = x; }
* }
*/
class LeetCode_21_628 {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if(l1 == null) return l2;
      if(l2 == null) return l1;
      ListNode res = new ListNode(-1) ;
      ListNode cur = res ;
      while (l1 != null || l2 != null){
          if(l1 == null){
              cur.next = l2 ;
              l2 = l2.next;
          }else if(l2 == null || l1.val <= l2.val){
              cur.next = l1 ;
              l1 = l1.next;
          }else{
              cur.next = l2 ;
              l2 = l2.next;
          }
          cur = cur.next;
      }
      return res.next ;

  }
}
//leetcode submit region end(Prohibit modification and deletion)

//【出现错误点】
//1、未考虑到l1为空的情况与l2为空情况的先后顺序。
//2、未考虑到如果以l1或l2的头结点作为起始结点的话，会导致循环指针出现。
