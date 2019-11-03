class Solution1:
    """
    Solve iteratively
    """

    class ListNode:
        def __init__(self, x):
            self.val = x
            self.next = None

    def reverseList(self, head: ListNode) -> ListNode:
        prev = None
        curr = head

        while curr:
            # store the next
            next = curr.next
            # reference original next to prev
            curr.next = prev

            # Below is iteration
            # prev move to the current
            prev = curr
            # loop thru the LL
            curr = next

        return prev


class Solution2:
    """
    A more Pythonic writing
    """

    class ListNode:
        def __init__(self, x):
            self.val = x
            self.next = None

    def reverseList(self, head: ListNode) -> ListNode:
        prev, curr = None, head
        while curr:
            curr.next, prev, curr = prev, curr, curr.next
        return prev


class Solution3:
    """
    Solve it recursively
    """

    class ListNode:
        def __init__(self, x):
            self.val = x
            self.next = None

    def reverseList(self, head: ListNode) -> ListNode:
        return self._reverseList(head)

    def _reverseList(self, head, prev=None):
        if not head:
            return prev
        next = head.next
        head.next = prev
        return self._reverseList(next, head)
