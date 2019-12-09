//206. 反转链表

//解法1：迭代法
//思路：把currentNode的next指针指向上一个元素即可,为此需要创建prev指针用于替换引用
//时间复杂度O(n)
//空间复杂度O(1)
public ListNode reverseList(ListNode head) {
	ListNode prev = null;
	ListNode curr = head;
	while (curr != null) {
		ListNode nextNode = curr.next;
		curr.next = prev;
		prev = curr;
		curr = nextNode;
	}
	return prev;
}

//解法2：递归
//思路：每一次递归,把当前node.next指向上一个node,直到当前node为NULL
//时间复杂度O(n)
//空间复杂度O(n)
//总结：递归思想在于找出重复子问题,这里的重复动作就是将当前节点的next指针指向上一个节点
 public static ListNode reverseList2(ListNode head) {
	/* recursive solution */
	return reverseListInt(head, null);
}

private static ListNode reverseListInt(ListNode head, ListNode newHead) {
	//terminate
	if (head == null)
		return newHead;

	//logical
	ListNode next = head.next;
	head.next = newHead;

	//recur
	return reverseListInt(next, head);
}
