/**
 * 题目： 二叉树的前序遍历
 * 语言： JavaScript
 * 执行结果： 打败了87%的用户
 * 方法： 递归
 * */


/**
 * @param {TreeNode} root
 * @return {number[]}
 */

const preorderTraversal = function (root) {
    const result = [];

    traversing(root,result);
    return result;
}

function traversing(node,arr) {
    if(node === null) return;
    arr.push(node.val);

    if(node.left !== null) arguments.callee(node.left,arr);
    if(node.right != null) arguments.callee(node.right,arr);
}
