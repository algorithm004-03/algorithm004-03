class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (null == l1) return l2;
    if (null == l2) return l1;
    ListNode origin = new ListNode(-1);
    ListNode prev = origin;
    while (null != l1 && null != l2) {
      if (l1.val <= l2.val) {
        prev.next = l1;
        l1 = l1.next;
      } else {
        prev.next = l2;
        l2 = l2.next;
      }
      prev = prev.next;
    }
    // exactly one of l1 and l2 can be non-null at this point, so connect
    // the non-null list to the end of the merged list.
    prev.next = null == l1 ? l2 : l1;
    return origin.next;
  }
  
  public ListNode mergeTwoLists_recursive(ListNode l1, ListNode l2) {
    if (null == l1) return l2;
    if (null == l2) return l1;
    if (l1.val <= l2.val) {
      l1.next = mergeTwoLists_recursive(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists_recursive(l2.next, l1);
      return l2;
    }
  }
  }
}