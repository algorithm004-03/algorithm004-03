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

        result.push_back(p_cur_node->val);
        dfs(result, p_cur_node->left);
        dfs(result, p_cur_node->right);
    }

    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result;
        dfs(result, root);
        return result;
    }
};