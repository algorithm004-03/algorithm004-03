/*
思路
dfs分别查找从根节点到两个节点的路径，然后查找两条路径中离根最远的且数值相等的节点
 */

#include <stdio.h>
#include <vector>
#include <unordered_set>
using namespace std;

/*
struct TreeNode {
     int val;
     TreeNode *left;
     TreeNode *right;
     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
 */

class Solution {
public:
    bool dfs(TreeNode* p_cur_node, int target, vector<TreeNode*>& path) {
        if (p_cur_node == nullptr) {
            return false;
        }

        path.push_back(p_cur_node);

        if (p_cur_node->val == target) {
            return true;
        }

        if (dfs(p_cur_node->left, target, path)) {
            return true;
        }

        if (dfs(p_cur_node->right, target, path)) {
            return true;
        }

        path.erase(path.end() - 1);
        return false;
    }


    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode*> path1, path2;
        vector<TreeNode*>* p_long_path = &path1;
        vector<TreeNode*>* p_short_path = &path2;

        dfs(root, p->val, path1);
        dfs(root, q->val, path2);

        if (p_long_path->size() < p_short_path->size()) {
            vector<TreeNode*>* p_tmp = p_long_path;
            p_long_path = p_short_path;
            p_short_path = p_tmp;
        }

        unordered_set<TreeNode*> set;
        for (TreeNode* ptr : *p_long_path) {
            set.insert(ptr);
        }

        for (int i = p_short_path->size()-1; i >= 0; i--) {
            if (set.find((*p_short_path)[i]) != set.end()) {
                return (*p_short_path)[i];
            }
        }

        return nullptr;
    }
};
