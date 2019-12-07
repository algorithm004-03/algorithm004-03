# 二叉树 Binary Tree
* 每个节点**最多**有两个子节点，分别是左子节点和右子节点
* 二叉树的遍历
  * 前序遍历（pre-order)：根-左-右
	* 时间复杂度：T(n) = O(n)
	* 代码模板
    ``` javascript
	function preorder(root) {
	    if (!root) {
	        return;
	    }
	
	    console.log(root.val);
	    preorder(root.left);
	    preorder(root.right);
	}
    ```
  * 中序遍历（in-order)：左-根-右
	* 时间复杂度：T(n) = O(n)
	* 代码模板
	``` javascript
	 function inorder(root) {
	     if (!root) {
	         return;
	     }
	 
	     console.log(root.val);
	     inorder(root.left);
	     inorder(root.right);
	 }
	 ```
  * 后序遍历（post-order)：左-右-根
	* 时间复杂度：T(n) = O(n)
	* 代码模板
	``` javascript
	function postorder(root) {
	    if (!root) {
	        return;
	    }
	
	    postorder(root.left);
	    postorder(root.right);
	    console.log(root.val);
	}
	```

# 二叉搜索树 Binary Search Tree
* 也称**二叉查找树**（Binary Search Tree）、**有序二叉树**（Ordered Binary Tree）、**排序二叉树**（Sorted Binary Tree）
* 性质
  1. 左子树上**所有结点**的值均**小于**它的根结点的值
  2. 右子树上**所有结点**的值均**大于**它的根结点的值
  3. 以此类推：左、右子树也分别为二叉查找树（这就是**重复性**！）
  4. 可通过**中序遍历**得到一个**升序排列**
* 时间复杂度
  * 平均情况
	  * access：O(logn)
	  * search：O(logn)
	  * insertion：O(logn)
	  * deletion：O(logn)
  * 极端情况，以上时间复杂度为：O(n)

# 递归
* **树**的面试题**解法**一般都是**递归** 
* 求解递归问题思路
	1. **不要人肉**进行递归（最大误区）
	2. 找到最近最简方法，将其**拆解成可重复**解决的问题（重复子问题）
		* 拆解成子问题
		* **问题**与**子问题**除了数据规模不同，求解思路一致
	3. 多运用**数学归纳法**思维
	4. 存在**终止条件**
* 代码模板
	```javascript
	function recursion(level, ...params) {
	    // 1. recursion terminator 递归终止条件
	    if (level > MAX_LEVEL) {
	        // 2. process result 处理结果
	        return;
	    }
	
	    // 3. process current logic 处理当前逻辑
	
	    // 4. drill down 递归处理下一层
	    recursion(level + 1, ...params);
	
	    // 5. restore current status if needed 如果需要，还原当前状态
	}
	```