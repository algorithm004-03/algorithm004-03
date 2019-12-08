//24. 两两交换链表中的节点

//解法1：递归
//思路：寻找重复子问题-head与nextTemp交换:
//		head.next->下一个交换的nextTemp(因此返回nextTemp), nextTemp.next->head
//时间复杂度：O(n)
//空间复杂度：O(n)
//总结：也算是在这道题里找到了一点递归的感觉... 在写递归的时候,关注的是当前需要重复做的事情,不要去考虑全局
//		把最后的返回条件确认后,思考当下的逻辑条件即可,因为递归的逻辑都是重复的
//		这也印证了超哥说的：不要人肉递归,因为没有必要！！！
public ListNode swapPairs(ListNode head) {
	if (head == null || head.next == null) {
		return head;
	}
	ListNode nextTemp = head.next;
	head.next = swapPairs(nextTemp.next);
	nextTemp.next = head;
	return nextTemp;
}