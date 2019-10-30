import java.util.HashMap;
import java.util.Map;

/**
 * 从前序和中序遍历序列构造二叉树
 * @author L
 *
 */
public class LeetCode_105_138 {
	/**
	 * 
	 * @param preorder 前序遍历：父节点 -左子节点-右子节点
	 * @param inorder  中序遍历:  左子节点-父节点-右子节点
	 * @return
	 * 思路：
	 * 	   前序遍历的第一个元素为根节点；中序遍历中，根节点所在位置的左侧为左子树，右侧为右子树
	 *     1 找到各个子树的根节点
	 *     2 构建该根节点的左子树
	 *     3 构建该根节点的右子树
	 *     4 重复1-3的问题
	 *     
	 */
	private Map<Integer,Integer>inMap = null;
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		inMap = mapIndex(inorder);
		return buildTreeHelper(preorder,0,preorder.length, inorder,0,inorder.length);
	}
	public TreeNode buildTreeHelper(int[] preorder,int ps,int pe, int[] inorder,int is,int ie) {
        /**
         * recursion terminator :递归终止条件
         */
		if(ps == pe)
		/*
		 * process result：处理结果
		 */
        	return null;
        /**
         * process logic in current level :当前层处理逻辑
         */
		//前序遍历第一个值为根节点，构造根节点
		TreeNode root = new TreeNode(preorder[ps]);
		//找到当前根节点在中序遍历数组里的index
		int mid = inMap.get(preorder[ps]);
		int left_num = mid -is;
		int pLeft = ps+left_num+1;
		
		/**
		 * drill down: 向下层探索递归调用 根据数学归纳法，转化为可重复解决的问题[重复子问题]
		 */
		
		//构建左子树
		root.left = buildTreeHelper(preorder,ps+1,pLeft,inorder,is,mid);
		
		//构建右子树
		root.right = buildTreeHelper(preorder, pLeft, pe, inorder, mid+1, ie);
		
		//reverse or restore the current level status if needed:必要时返回或者保存当前层的状态
		
		return root;
    }
	
	/**
	 * 存放元素与位置的对应关系
	 * @param array
	 * @return
	 */
	private Map<Integer,Integer> mapIndex(int[] array) {
		Map<Integer,Integer> map = new HashMap();
		for(int i=0;i<array.length;i++) {
			map.put(array[i], i);
		}
		return map;
	}
	

	public static void main(String[] args) {
//		int[] x = {1,2,3,4,5,6};
//		int[] k = Arrays.copyOfRange(x, 1, x.length);
//		for(int i:k) {
//			System.out.println(i);
//		}
		
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
//		TreeNode root = new LeetCode_105_138().buildTree(preorder, inorder);
		
		Map<Integer,Integer>inMap = new LeetCode_105_138().mapIndex(inorder);
		//找到当前根节点在中序遍历数组里的index
		int mid = inMap.get(preorder[0]);
		System.out.println(mid);
		
		
	}
	
	
}
