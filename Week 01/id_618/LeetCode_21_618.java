	class Solution {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (l1 == null) {
				return l2;
			}

			if (l2 == null) {
				return l1;
			}

			// 头节点，最后的返回值
			ListNode head = null;
			// 标记当前节点
			ListNode current = null;
			// 与当前节点比较的目标节点
			ListNode target = null;

			// 比如l1和l2的头，初始化head current和target
			if (l1.val < l2.val) {
				head = l1;
				target = l2;
			} else {
				head = l2;
				target = l1;
			}

			current = head;

			while (target != null) {
				// 退出判断：已经是最后一个，追加target后退出循环
				if (current.next == null) {
					current.next = target;
					break;
				}

				if (current.next.val > target.val) {
					// current.next和target引用交换，继续比较
					ListNode temp = target;
					target = current.next;
					current.next = temp;
				} else {
					//移到后一个节点，继续比较
					current = current.next;
				}
			}

			return head;

		}
	}