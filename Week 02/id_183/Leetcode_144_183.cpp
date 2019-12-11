/*
 * @lc app=leetcode id=144 lang=cpp
 *
 * [144] Binary Tree Preorder Traversal
 */

// @lc code=start
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
       vector<int> res;
        if(!root){
            return res;
        }
        stack<TreeNode*> bucket;
        
        bucket.push(root);
        while(!bucket.empty())
        {
            TreeNode* cur = bucket.top();
            res.push_back(cur->val);
            bucket.pop();
            if(cur->right)
            {
                bucket.push(cur->right);
            }
            
            
            if(cur->left)
            {
                bucket.push(cur->left);
            }
            
            
        }
        
        return res;
    }
};
// @lc code=end

