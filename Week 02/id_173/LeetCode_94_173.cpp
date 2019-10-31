/*
 * 94. 二叉树的中序遍历
 */

class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode*> s;
        TreeNode* curNode = root;

        while(curNode || !s.empty()) {
            while(curNode) {
                s.push(curNode);
                curNode = curNode->left;
            }

            TreeNode* top = s.top();
            s.pop();
            res.push_back(top->val);
			
            curNode = top->right;
        }

        return res;
    }
};