//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树



//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        Stack<Node> s = new Stack<>();
        List<Integer> result = new LinkedList<>();
        Node top;
        int i,len;
        if(root==null)return result;
        s.push(root);
        while(!s.isEmpty()){
            top = s.pop();
            len = top.children.size();
            result.add(0,top.val);
            for(i=0;i<len;i++){
                s.push(top.children.get(i));
            }
        }
        return result;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
