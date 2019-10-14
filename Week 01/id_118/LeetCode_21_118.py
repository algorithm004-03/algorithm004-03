class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution1:
    """
    Merge two sorted ListNodes recursively
    1. if l1.val < l2.val, l1=>mergeTwoLists(l1.next, l2)
    2. if l1.val > l2.val, l2=>mergeTwoLists(l1,  l2.next)
    """
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # use recursion
        if l1 is None and l2 is None:
            return None
        if l1 is None:
            return l2
        elif l2 is None:
            return l1
        elif l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l2.next, l1)
            return l2

def test_1(list_1, list_2):
    pass