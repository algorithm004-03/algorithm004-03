#include <iostream> 
#include <vector>
#include <stack>
using namespace std;

//94. 二叉树的中序遍历
struct TreeNode {
	int val;
	TreeNode * left;
	TreeNode * right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
vector<int> result;

/*
解题思路一：递归
时间复杂度：O(n) 
方法：先左在左一层一层的下探，到叶子节点的时候返回上一层add该子树的root节点，然后在一层一层的下探右子树......
*/

#if 0
vector<int> inorderTraversal(TreeNode* root) {
	if (root != NULL) {
		inorderTraversal(root->left);
		result.push_back(root->val);
		inorderTraversal(root->right);
	}
	
	return result;
}
#endif

/*
解题思路二：使用栈
时间复杂度：O(n)
方法：每一层下探存做左子树，如果到叶子节点就把改节点弹出，然后在操作右子树.......
*/
vector<int> inorderTraversal(TreeNode* root) {
	vector<int> result;
	stack<TreeNode*> treeStack;
	TreeNode * cur = root;
	while (cur != NULL || !treeStack.empty()) {
		while (cur != NULL) {
			treeStack.push(cur);
			cur = cur->left;
		}

		result.push_back(treeStack.top()->val);     //44行代码与50行代码存在一个一入一出的互斥关系，
		cur = treeStack.top()->right;				//所以不存在cur != NULL,但是treeStack is empty的关系，就是不存在treeStack为空还pop的操作
		treeStack.pop();
	}

	return result;
}

/*
int main()
{

	return 0;
}
*/