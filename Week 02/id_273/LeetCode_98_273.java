//98. 验证是否是BSTree

//解法1：深度优先遍历		执行用时击败100%
//思路：优先深入左子树, 判断左节点与父节点的value大小关系, 然后再去右子树
//时间复杂度O(n) 深度优先遍历每个节点, 且仅遍历一遍
//空间复杂度O(n)
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    private boolean helper(TreeNode root, long maxVal, long minVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return helper(root.left, root.val, minVal) && helper(root.right, maxVal, root.val);
    }
}


//解法2：广度优先遍历		执行用时击败约30%
//思路：用队列保存节点的信息, 逐层验证
//时间复杂度O(n)
//空间复杂度O(n)
class Solution {
    Queue<TreeNode> queue = new LinkedList();
    Queue<Integer> uppers = new LinkedList();
    Queue<Integer> lowers = new LinkedList();

    public void update(TreeNode root, Integer lower, Integer upper) {
        queue.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    public boolean isValidBST(TreeNode root) {
        Integer lower = null, upper = null;
        update(root, lower, upper);
        while (!queue.isEmpty()) {
            root = queue.poll();
            lower = lowers.poll();
            upper = uppers.poll();
            if (root != null) {
                if (lower != null && root.val <= lower) return false;
                if (upper != null && root.val >= upper) return false;
                update(root.left, lower, root.val);
                update(root.right, root.val, upper);
            }
        }
        return true;
    }
}

//解法3：中序遍历观察是否有序	执行用时击败约40%
//思路：基于二叉树中序遍历为从小到大的特性,每当进行一次中序遍历时,就与上一个节点的val值比较
//时间复杂度O(n)
//空间复杂度O(n)
//总结：活用辅助栈完成迭代式中序遍历
public boolean isValidBST(TreeNode root) {
	Stack<TreeNode> stack = new Stack<>();
	TreeNode prev = null;
	while (!stack.isEmpty() || root != null) {
		while(root != null) {
			stack.push(root);
			root = root.left;
		}
		root = stack.pop();
		if (prev != null && root.val <= prev.val) return false;
		prev = root;
		root = root.right;
	}
	return true;
}