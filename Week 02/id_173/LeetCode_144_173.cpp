/*
 * 144. 二叉树的前序遍历
 */

class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode*> s;
        TreeNode* curNode = root;

        while(curNode || !s.empty()) {
            while(curNode) {
                res.push_back(curNode->val);
                s.push(curNode);
                curNode = curNode->left;
            }

            TreeNode* top = s.top();
            s.pop();
			
            curNode = top->right;
        }

        return res;
    }
};