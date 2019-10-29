/**
 * 题目： 二叉树的中序遍历
 * 语言： JavaScript
 * 执行结果： 打败了96%的用户
 * 方法： 递归
 * */


/**
 * @param {TreeNode} root
 * @return {number[]}
 */

const inorderTraversal = function(root) {
    let result = [];
    traversing(root,result);

    return result;
};


function traversing(node,arr) {
    if(node === null) return;
    if(node.left !== null) {
        arguments.callee(node.left,arr)
    };
    arr.push(node.val);
    if(node.right !== null) {
        arguments.callee(node.right,arr);
    };
}
