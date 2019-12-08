/*
 * @lc app=leetcode id=429 lang=cpp
 *
 * [429] N-ary Tree Level Order Traversal
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
    vector<vector<int>> levelOrder(Node* root) {
       if(!root) return {};
        vector<vector<int>> ans;
        queue<Node*> que;
        que.push(root);
        while(!que.empty())
        {
            vector<int> v;
            for(int i=que.size();i;i--)
            {
                //压入当前层
                Node* curr=que.front();
                que.pop();
                v.push_back(curr->val);
                for(Node* it:curr->children)
                    que.push(it);
            }
            ans.push_back(v);
        }
        return ans;
    }
};
// @lc code=end

