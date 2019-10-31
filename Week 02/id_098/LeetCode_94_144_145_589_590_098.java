//二叉树中序遍历(递归） LeetCode 94
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        traversal(root, res);
        return res;
    }

    public void traversal(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                traversal(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                traversal(root.right, res);
            }
        }
    }

}

//二叉树前序遍历(递归） LeetCode 144
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        traversal(root, res);
        return res;
    }

    public void traversal(TreeNode root, List < Integer > res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                traversal(root.left, res);
            }
            if (root.right != null) {
                traversal(root.right, res);
            }
        }
    }

}

//二叉树后序遍历(递归） LeetCode 145
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        traversal(root, res);
        return res;
    }

    public void traversal(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                traversal(root.left, res);
            }
            if (root.right != null) {
                traversal(root.right, res);
            }
            res.add(root.val);
        }
    }
}

//N叉树前序遍历(递归） LeetCode 589
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

    public List<Integer> preorder(Node root) {
        List < Integer > res = new ArrayList < > ();
        traversal(root, res);
        return res;
    }

    public void traversal(Node root, List < Integer > res) {
        if (root != null) {
            res.add(root.val);

            int s = root.children.size();
            for(int i = 0; i < s; i++) {
                traversal(root.children.get(i), res);
            }
        }
    }
}

//N叉树后序遍历(递归） LeetCode 590
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
        List < Integer > res = new ArrayList < > ();
        traversal(root, res);
        return res;
    }

    public void traversal(Node root, List < Integer > res) {
        if (root != null) {

            int s = root.children.size();
            for(int i = 0; i < s; i++) {
                traversal(root.children.get(i), res);
            }
            res.add(root.val);
        }
    }
}
