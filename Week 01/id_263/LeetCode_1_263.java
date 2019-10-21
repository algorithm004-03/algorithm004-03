package io.beansoft.pencil.leetcode;


/**
 * @author beanlam
 * @version 1.0
 * @date 2019-10-20 16:54
 */
public class LeetCode_1_263 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode a = l1;
        ListNode b = l2;

        int upValue = 0;
        ListNode currentNodePointer = result;
        while (a != null || b != null) {
            int aval = 0;
            int bval = 0;
            if (a != null) {
                aval = a.val;
            }
            if (b != null) {
                bval = b.val;
            }
            int nextUpValue = (aval + bval + upValue) >= 10 ? 1 : 0;
            int currentVal = ((aval + bval + upValue) % 10);

            upValue = nextUpValue;

            if (currentNodePointer == null) {
                result = new ListNode(currentVal);
                currentNodePointer = result;
            } else {
                currentNodePointer.next = new ListNode(currentVal);
                currentNodePointer = currentNodePointer.next;
            }

            if (a != null) {
                a = a.next;
            }
            if (b != null) {
                b = b.next;
            }
        }
        if (upValue > 0) {
            currentNodePointer.next = new ListNode(upValue);
        }

        return result;

    }
}
