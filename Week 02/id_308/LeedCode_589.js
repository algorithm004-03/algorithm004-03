/**
 * 题目： N叉树的前序遍历
 * 语言： JavaScript
 * 执行结果： 打败了90%的用户
 * 方法： 递归
 * */


/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorder = function(root) {
    const result = [];
    traversing(root,result,0)
    return result;
};

function traversing(node,arr,index) {
    if(node === null) return;

    const {val,children} = node;
    const temp = arr[index] || [];

    temp.push(val);
    arr[index++] = temp;

    if(children && children.length > 0) {
        for (let i = 0; i < children.length; i++) {
            arguments.callee(children[i],arr,index);
        }
    }
}
