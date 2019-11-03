/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int>ans;
        if(root) inorderT(ans, root);
        return ans;
    }
    void inorderT(vector<int>&v, TreeNode* root) {
        if(root->left) inorderT(v, root->left);
        v.push_back(root->val);
        if(root->right) inorderT(v, root->right);
    }
};
