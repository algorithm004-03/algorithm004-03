public class MergeTwoLists {
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        ListNode tmp = new ListNode(-1);
        boolean firstSetNewHead = true;
        while (l1 != null || l2 != null) {
            if(l1 == null) {
                tmp.next = l2;
                l2 = l2.next;
            }else if(l2 == null) {
                tmp.next = l1;
                l1 = l1.next;
            }else {
                if (l1.val > l2.val) {
                    tmp.next = l2;
                    l2 = l2.next;
                } else {
                    tmp.next = l1;
                    l1 = l1.next;
                }
               
            }
            if(firstSetNewHead) {
                newHead = tmp;
                firstSetNewHead = false;
            }
            tmp = tmp.next;
        }
        if(newHead == null) {
            return null;
        }
        return newHead.next;
    }
}