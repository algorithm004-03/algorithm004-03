/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function(head, k) {
    if (!head) {
        return null;
    }

    if (k < 2) {
        return head;
    }

    // 先统计总结点数
    var total = 0;
    var current = head;

    while (current) {
        ++total;
        current = current.next;
    }

    if (k > total) {
        return head;
    }

    // 计算组数
    var group = (total - total % k) / k;

    // 重新迭代一次
    var currentGroup = 0;
    var currentIndex = 0;
    var node = { next: head };
    var prev = node, current = head, next = head.next;
    var _current, _next;
    var prevTail = node, currentTail;

    while (current) {
        _current = current;
        _next = current.next;

        if (currentIndex === 0) {
            currentTail = current;
            ++currentIndex;
        }
        else {
            _next = current.next;
            current.next = prev;
            ++currentIndex;

            if (currentIndex >= k) {
                prevTail.next = current;
                prevTail = currentTail;
                currentIndex = 0;
                ++currentGroup;

                if (currentGroup >= group) {
                    prevTail.next = _next;
                    break;
                }
            }
        }

        prev = _current;
        current = _next;
    }

    return node.next;
};
