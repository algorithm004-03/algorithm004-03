/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var preorder = function (root) {
    if (!root) {
        return [];
    }

    let orderNums = [];
    orderNums.push(root.val);

    if (root.children) {
        for (let i = 0; i < root.children.length; i++) {
            orderNums = orderNums.concat(preorder(root.children[i]));
        }
    }

    return orderNums;
};

// 迭代法
var preorderWithIteration = function (root) {
    if (!root) {
        return [];
    }

    let orderNums = [];
    const stack = [root]; // 模拟栈

    while (stack.length) {
        const node = stack.pop();
        orderNums.push(node.val);

        if (node.children) {
            for (let i = node.children.length - 1; i >= 0; i--) {
                stack.push(node.children[i]);
            }
        }
    }

    return orderNums;
};