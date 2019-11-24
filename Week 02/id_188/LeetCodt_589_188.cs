/*
 * @lc app=leetcode.cn id=589 lang=csharp
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
/*
// Definition for a Node.
public class Node {
    public int val;
    public IList<Node> children;

    public Node(){}
    public Node(int _val,IList<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/
public class Solution {
    public IList<int> Preorder(Node root) {
        var ret = new List<int>();
        if(root == null){
            return ret ;
        }
        ret.Add(root.val);
        foreach (var node in root.children){
            ret.AddRange(Preorder(node));
        }
        return ret;
    }
}
// @lc code=end

