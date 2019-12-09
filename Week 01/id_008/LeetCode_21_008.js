/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    if (!l1 && !l2) {
        return null;
    }

    var list = [];
    var current = l1;

    while (current) {
        list.push(current.val);
        current = current.next;
    }

    var current = l2;

    while (current) {
        list.push(current.val);
        current = current.next;
    }

    list.sort(function(a, b){ return a - b; });

    var result = {};
    current = result;

    for (var i = 0; i < list.length; ++i) {
        current.val = list[i];

        if (i >= list.length - 1) {
            current.next = null
        }
        else {
            current.next = {};
            current = current.next;
        }
    }

    return result;
};
