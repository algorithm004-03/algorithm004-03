package id_713.more;

public class LinkedListCycleII {


    public ListNode detectCycle(ListNode head) {
        ListNode node = this.helper(head);

        if (node == null) return null;

        ListNode curr = head;
        while (curr != node) {
            curr = curr.next;
            node = node.next;
        }
        return curr;
    }

    private ListNode helper(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }




    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
