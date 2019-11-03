/**
 * 题目： N叉树的后序遍历
 * 语言： JavaScript
 * 执行结果： 打败了94%的用户
 * 方法： 递归
 * */


/**
 * @param {TreeNode} root
 * @return {number[]}
 */

const postorder = function(root) {
    const result = [];
    traversing(root,result);
    return result;
};

function traversing(node,arr) {
    if(node === null) return;

    const {children} = node;
    if(children && children.length > 0) {
        for(let i = 0; i < children.length; i++) {
            arguments.callee(children[i],arr);
        }
    }

    arr.push(node.val);
}
