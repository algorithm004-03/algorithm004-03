//25. K个一组翻转链表

//解法1：递归
//思路：结合了206. 反转链表和24. 两两交换链表节点的思想,可以将该题k=2的情况理解为反转链表求解
//		首先获取k+1 node,
//		if (k+1 node exist) 那么可以进行k次节点交换
//		else 说明后面的节点不足k个 直接return head
//时间复杂度O(n)
//空间复杂度O(n), 并不符合题目要求...
//总结：渐渐对递归的掌握越来越熟练,虽然自己写不出来这么优秀的递归,但是已经明白如何正确阅读递归程序了,
//		核心思想就在于找到重复子问题
public ListNode reverseKGroup(ListNode head, int k) {
	//terminate
	if (head == null || head.next == null) return head;
	int count = 0;
	ListNode curr = head;
	//find the k+1 node
	while (curr != null && count != k) {
		curr = curr.next;
		count++;
	}
	//if k+1 node is found ... / else return head
	if (count == k) {
		curr = reverseKGroup(curr, k);
		//完成k次交换
		while (count-- > 0) {
			ListNode nextTemp = head.next;
			head.next = curr;
			curr = head;
			head = nextTemp;
		}
		//最后的curr一定是交换后的头元素
		head = curr;
	}
	return head;
}