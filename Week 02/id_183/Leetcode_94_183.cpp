/*
 * @lc app=leetcode id=94 lang=cpp
 *
 * [94] Binary Tree Inorder Traversal
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
    vector<int> inorderTraversal(TreeNode* root) {
        stack<TreeNode> s;
        vector<int> ans;
        TreeNode* t = root;
        while(t || !s.empty())
        {
            while(t)
            {
                s.push(*t);
                t = t->left;
            }
            if(!s.empty())
            {
                ans.push_back(s.top().val);
                t = s.top().right;
                s.pop();
            }
        }
        return ans;
    }
};
// @lc code=end

