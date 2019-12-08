/*
 * @lc app=leetcode.cn id=94 lang=cpp
 *
 * [94] 二叉树的中序遍历
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
        vector<int> res;        
        DoActualWork(root, res);
        return res;     
    }

    void DoActualWork(TreeNode* node, vector<int> &save) {
        if (node != NULL) {
            if (node->left != NULL)
            {
                DoActualWork(node->left, save);
            }
            save.push_back(node->val);
            if (node->right != NULL) {
                DoActualWork(node->right, save);
            }
        }
    }

};
// @lc code=end

