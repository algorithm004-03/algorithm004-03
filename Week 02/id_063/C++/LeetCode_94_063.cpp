
#include <stdio.h>
#include <vector>
using namespace std;


 struct TreeNode {
     int val;
     TreeNode *left;
     TreeNode *right;
     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };

class Solution {
public:

    void dfs(vector<int>& result, TreeNode* p_cur_node) {
        if (p_cur_node == nullptr) {
            return;
        }

        dfs(result, p_cur_node->left);
        result.push_back(p_cur_node->val);
        dfs(result, p_cur_node->right);
    }

    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> v;
        dfs(v, root);

        return v;
    }
};