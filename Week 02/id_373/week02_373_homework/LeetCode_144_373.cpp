#include <iostream>
#include <vector>
#include <stack>
using namespace std;

//144. 二叉树的前序遍历
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	
	TreeNode(int x) : val(x), left(NULL), right(NULL) { }
};


//vector<int> result;
/*
解题思路一：递归
时间复杂度：O(n)
方法：先根节点在下探到下一层遍历左子树，然后在右子树......
*/
#if 0
vector<int> preorderTraversal(TreeNode *root) {
	if (root != NULL) {
		result.push_back(root->val);
		preorderTraversal(root->left);
		preorderTraversal(root->right);
	}

	return result;
}
#endif

/*
解题思路二：使用stack
时间复杂度：O(n)
方法：从根节点开始直接保存根节点和左孩子，右孩子放到栈中......
*/
#if 0
vector<int> preorderTraversal(TreeNode *root) {
	vector<int> result;
	stack<TreeNode *> treeNodeStack;
	TreeNode *cur = root;
	while (cur != NULL || !treeNodeStack.empty()) {
		while (cur != NULL) {
			if (cur->right != NULL) {
				treeNodeStack.push(cur->right);
			}
			result.push_back(cur->val);
			cur = cur->left;
		}

		if (!treeNodeStack.empty()) {   //如果上面的cur->right is empty，则treeNodeStack为空，然后pop就出现段错误。
			cur = treeNodeStack.top();
			treeNodeStack.pop();
		}
	}
	return result;
}
#endif

/*
解题思路三：使用stack
时间复杂度：O(n)
方法：先根节点开始保存到栈中，然后先把右孩子保存到栈中，在保存左孩子，然后弹出top（也就是左孩子）重复操作......
*/
vector<int> preorderTraversal(TreeNode *root) {
	vector<int> result;
	if (root == NULL)
		return result;

	stack<TreeNode *> treeNodeStack;

	TreeNode * cur = root;
	treeNodeStack.push(cur);
	while (!treeNodeStack.empty()) {
		cur = treeNodeStack.top();
		result.push_back(cur->val);

		treeNodeStack.pop();

		if (cur->right != NULL) {
			treeNodeStack.push(cur->right);
		}

		if (cur->left != NULL) {
			treeNodeStack.push(cur->left);
		}
	}

	return result;
}

//二叉树的递归方式创建

int main()
{
	TreeNode node3(3);
	TreeNode node2(2);
	node2.left = &node3;
	TreeNode node1(1);
	node1.right = &node2;

	vector<int> result = preorderTraversal(&node1);

	for (int item : result)
	{
		cout << item << endl;
	}


	while (1);
	return 0;
}