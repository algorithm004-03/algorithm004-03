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
var reverseList = function(head) {
    if (!head) {
        return null;
    }

    var list = [head.val];

    while (head.next) {
        head = head.next;
        list.push(head.val);
    }

    var pop, newList = {};
    var result = newList;

    while (list.length) {
        pop = list.pop();
        newList.val = pop;

        if (list.length) {
            newList.next = {};
            newList = newList.next;
        }
    }

    return result;
};
