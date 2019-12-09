/*
 * @lc app=leetcode id=590 lang=cpp
 *
 * [590] N-ary Tree Postorder Traversal
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
    vector<int> postorder(Node* root) {
                vector<int> ans;
        pso(ans, root);
        return ans;
        }
        void pso(vector<int>& ans,Node* root)
        {
        if (root)
        {
        for (int i = 0; i < root->children.size(); i++)
        pso(ans, root->children[i]);
        ans.push_back(root->val);
        }
    }
};
// @lc code=end

