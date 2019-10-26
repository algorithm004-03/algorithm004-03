# Definition for singly-linked list.
class ListNode:
    def __init__(self, e):
        self.val = e
        self.next = None


class Solution1:
    """
    1. Iterative Solution
    The time complexity for this solution will be O(n^2) due to nexted iteration
    it will have TLE (Time Limit Exceeded) error
    """

    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        """
        Solve this problem iteratively
        :param l1:
        :param l2:
        :return:
        """
        # Create a dummy head node
        dummy_head = curr = ListNode(None)

        # while l1 and l2 are not empty LL
        # compare the value and connect smaller node to dummy_head
        # Time Complexity is O(n)
        while l1 and l2:
            if l1.val <= l2.val:
                # If l1.val is no greater than l2, connect l1 with dummy_head
                # iterate to l1's next
                curr.next = l1  # nexted iteration, time complexity is O(n)
                l1 = l1.next
            else:
                # If l1.val is greater than l2, connect l2 with curr
                # iterate to l2's next
                curr.next = l2
                l2 = l2.next

            # if l1 or l2 is empty
            # connect to the remainder either rest of l1, rest of l2 or None
            curr.next = l1 or l2
            # iterate thru the new list
            curr = curr.next

        return dummy_head.next


class Solution2:
    """
    2. Solve the problem with recursion
    """

    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # edge case: if any list is empty
        # return either one of the list or empty
        if None in (l1, l2):
            return l1 or l2
        # this is a more Pythonic way of checking if either l1 or l2 is empty
        # same as below
        # if not l1 or not l2:
        #     return l1 or l2

        # if neither lists is empty
        if l1.val <= l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2
