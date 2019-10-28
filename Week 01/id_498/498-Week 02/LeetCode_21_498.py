# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 is None:
            return l2
        elif l2 is None:
            return l1
        else:
            # 要创建一個空节点，也相当于做个备份
            tmp = ListNode(0)
            # 创建个头回来好找链表的头
            head = tmp
            # 如果 l1 和 l2 都为空，就证明链表结束了。
            while l1 and l2:
                # l1 要和 l2 比较
                if l1.val < l2.val:
                    tmp.next = l1
                    # 倒l1
                    l1 = l1.next
                else:
                    tmp.next = l2
                    # 倒l2
                    l2 = l2.next
                # 倒新链表
                tmp = tmp.next
            # 因为l1和l2只要有None就结束了
            tmp.next = l2 if l1 is None else l1
            return head.next