/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
    if (!head) {
        return false;
    }

    var a = head;
    var b = head;
    var start = true;

    while (a.next && b.next) {
        if (!start && a === b) {
            return true;
        }

        start = false;
        a = a.next;
        b = b.next;

        if (!b.next) {
            return false;
        }

        b = b.next;
    }

    return false;
};
