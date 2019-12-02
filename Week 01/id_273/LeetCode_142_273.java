//142. 环形链表II

//解法1：HashSet
//思路：参考141-HashSet
//时间复杂度O(n)
//空间复杂度O(n)
//总结：效率低下,不可取
public ListNode detectCycle(ListNode head) {
	HashSet<ListNode> set = new HashSet<>();
	ListNode curr = head;
	while (curr != null) {
		if (set.contains(curr)) {
			return curr;
		} else {
			set.add(curr);
		}
		curr = curr.next;
	}
	return null;
}

//解法2：双指针
//思路：参考141-双指针,这里要求的是环的连接点是哪里
//		除了上述方法还有一种通过数学证明的解法...
//时间复杂度O(n)
//空间复杂度O(1)
//总结：虽然效率是要比起HashMap高,但是我个人更倾向于直观的解法...
public ListNode detectCycle(ListNode head) {
	if (head == null || head.next == null) {
		return null;
	}
	ListNode intersect = getIntersect(head);
	//no cycle
	if (intersect == null) {
		return null;
	}
	ListNode ptr1 = head;
	ListNode ptr2 = intersect;
	while (ptr1 != ptr2) {
		ptr1 = ptr1.next;
		ptr2 = ptr2.next;
	}

	return ptr1;

}
private ListNode getIntersect(ListNode head) {
	ListNode tortoise = head;
	ListNode hare = head;
	while (hare != null && hare.next != null) {
		tortoise = tortoise.next;
		hare = hare.next.next;
		if (tortoise == hare) {
			return tortoise;
		}
	}
	return null;
}
