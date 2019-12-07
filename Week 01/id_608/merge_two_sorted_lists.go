package main

//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	head := &ListNode{}
	newList := head

	for l1 != nil || l2 != nil {
		if l1 == nil || (l2 != nil && l1.Val > l2.Val) {
			newList.Next = l2
			newList = l2
			l2 = l2.Next
		} else {
			newList.Next = l1
			newList = l1
			l1 = l1.Next
		}
	}
	return head.Next
}

//leetcode submit region end(Prohibit modification and deletion)
