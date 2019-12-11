public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pos1 = l1;
        ListNode pos2 = l2;

        ListNode head = null;
        ListNode tail = null;
        ListNode newNode = null;

        while (! ((pos1 == null) && (pos2 == null))) {
            if ((pos1 != null) && (pos2 != null)) {
                newNode = new ListNode(Math.min(pos1.val, pos2.val));
                if (pos1.val <= pos2.val) {
                    pos1 = pos1.next;
                } else {
                    pos2 = pos2.next;
                }
            } else if (pos1 == null) {
                newNode = new ListNode(pos2.val);
                pos2 = pos2.next;
            } else {
                newNode = new ListNode(pos1.val);
                pos1 = pos1.next;
            }

            if (head == null) {
                tail = head = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }
}