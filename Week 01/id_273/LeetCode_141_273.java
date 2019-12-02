//141. 环形链表

//解法1：HashSet
//思路：遍历链表,若当前节点已经存放在map中,则说明有环,若没有则把当前节点放入set
//时间复杂度O(n)
//空间复杂度O(n)
//总结：效率较低
public static boolean hasCycle2(ListNode head) {
	HashSet<ListNode> set = new HashSet<>();
	ListNode curr = head;
	while (curr != null) {
		if (set.contains(curr)) {
			return true;
		} else {
			set.add(curr);
		}
		curr = curr.next;
	}
	return false;
}

//解法2：快慢指针
//思路：满指针一次走一步,快指针一次走两步,若有环,那么快指针必定会与满指针相遇
//时间复杂度O(n)
//空间复杂度O(1)

public boolean hasCycle(ListNode head) {
	if (head == null || head.next == null) {
		return false;
	}
	ListNode slow = head;
	ListNode quick = head;
	while (quick.next != null && quick.next.next != null) {
		slow = slow.next;
		quick = quick.next.next;
		if (slow == quick) return true;
	}
	return false;
}