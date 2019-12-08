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
var swapPairs = function(head) {
    if (!head) {
        return null;
    }

    var list = [head.val];

    while (head.next) {
        head = head.next;
        list.push(head.val);
    }

    var temp = 0;

    for (var i = 1; i < list.length; i += 2) {
        temp = list[i];
        list[i] = list[i - 1];
        list[i - 1] = temp;
    }

    var pop, newList = {};
    var result = newList;

    while (list.length) {
        pop = list.shift();
        newList.val = pop;

        if (list.length) {
            newList.next = {};
            newList = newList.next;
        }
    }

    return result;
};
