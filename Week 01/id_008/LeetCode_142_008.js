/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function(head) {
    if (!head) {
        return null;
    }

    var a = head;
    var b = head;
    var start = true;
    var meet = null;

    while (a.next && b.next) {
        if (!start && a === b) {
            meet = a;
            break;
        }

        start = false;
        a = a.next;
        b = b.next;

        if (!b.next) {
            return null;
        }

        b = b.next;
    }

    if (meet) {
        a = head;

        while (1) {
            if (a === meet) {
                return meet;
            }

            a = a.next;
            meet = meet.next;
        }
    }
    else {
        return null;
    }
};
