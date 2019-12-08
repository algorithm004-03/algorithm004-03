/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//1、暴力法。
//首先:遍历两次树,找出p与q的父列表pPath与qPath。
//然后:循环比较pPath与qPath,找出最后一个相同的节点即为最近祖先节点
//---居然:超时了,应该是10000节点那个用例。其次,自我感觉中间变量太多

class Solution {
    private List<TreeNode> pPath = new ArrayList<TreeNode>();
    private List<TreeNode> qPath = new ArrayList<TreeNode>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pTempPath = new ArrayList<TreeNode>();
        List<TreeNode> qTempPath = new ArrayList<TreeNode>();
        getPath(root,p,pTempPath,pPath);
        getPath(root,q,qTempPath,qPath);
        TreeNode parentNode = pPath.get(0);
        for(int i=0;i<pPath.size()&& i<qPath.size();i++){
            if(pPath.get(i) == qPath.get(i)){
                parentNode = pPath.get(i);
            }else{
                break;
            }
        }
        return parentNode;
    }
    public void getPath(TreeNode currentNode,TreeNode searchedNode,List path,List resultPath){
        path.add(currentNode);
        if(currentNode == searchedNode){
            resultPath.addAll(path);
            return ;
        }
        if(currentNode.left !=null){
            List<TreeNode> currentPath = new ArrayList<TreeNode>();
            currentPath.addAll(path);
            getPath(currentNode.left,searchedNode,currentPath,resultPath);
        }
        if(currentNode.right !=null){
            List<TreeNode> currentPath = new ArrayList<TreeNode>();
            currentPath.addAll(path);
            getPath(currentNode.right,searchedNode,currentPath,resultPath);
        }
    }
}
//借鉴官网 深度优先+回溯,比官方少一层遍历
class Solution {

    public TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        findMark(root,p,q);

        return ans;
    }

    public boolean findMark(TreeNode currentNode,TreeNode p,TreeNode q){

        int currentMark = (currentNode ==p || currentNode ==q )?1:0 ;

        int leftMark = (currentNode.left == null) ? 0 : (findMark(currentNode.left,p,q)? 1: 0 );

        int rightMark = (currentNode.right == null) ? 0 : (findMark(currentNode.right,p,q)? 1: 0) ;
        //
        if((currentMark + leftMark+ rightMark) == 2){
            this.ans = currentNode ;
        }
        //
        return (currentMark + leftMark+ rightMark) > 0 ;


    }
}
