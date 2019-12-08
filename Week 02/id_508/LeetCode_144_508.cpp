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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result;
        if(root)
        preOrder(root,result);
        return result;
    }
    void preOrder(const TreeNode* root, vector<int>& result) {
        //if(!root) return;
        result.push_back(root->val);
        if(root->left) preOrder(root->left,result);
        if(root->right) preOrder(root->right,result);
    }
};
