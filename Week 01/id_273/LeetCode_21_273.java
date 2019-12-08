//21. 合并两个有序链表

//解法1：迭代解法	执行用时击败约91%
//思路：创建一个辅助TreeNode, 将比较大小后的结果暂存到TreeNode.next
//时间复杂度O(n + m) 受限于两个链表的长度
//空间复杂度O(1)
//总结：相比起递归解法, 迭代要更加直观易读
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	ListNode res = new ListNode(-1);
	ListNode resTemp = res;
	while (l1 != null && l2 != null) {
		if (l1.val <= l2.val) {
			resTemp.next = l1;
			l1 = l1.next;
		} else {
			resTemp.next = l2;
			l2 = l2.next;
		}
		resTemp = resTemp.next;
	}
	resTemp.next = (l1 == null) ? l2 : l1;
	return res.next;
}

//解法2：递归解法	执行用时击败约91%
//思路：如果l1的value更小, 则将l1.next指向排序好的链表表头, l2同理
//时间复杂度O(n + m)
//空间复杂度O(n + m)
//总结：递归方法首先要明确重复做什么, 什么时候终止
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	//terminate
	if (l1 == null) return l2;
	if (l2 == null) return l1;

	if (l1.val <= l2.val) {
		l1.next = mergeTwoLists(l1.next, l2);
		return l1;
	} else {
		l2.next = mergeTwoLists(l1, l2.next);
		return l2;
	}
}

