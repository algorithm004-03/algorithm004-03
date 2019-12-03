/*
 * @lc app=leetcode id=589 lang=cpp
 *
 * [589] N-ary Tree Preorder Traversal
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
    vector<int> preorder(Node* root) {
         vector<int> ret;
        stack<Node* > s;
        s.push(root);
        while(!s.empty()){
            root = s.top();s.pop();
            if(!root) continue;
            ret.push_back(root->val);
            for(int i = root->children.size()-1;i>=0;--i){
                s.push(root->children[i]);
            }
        }
        return ret;

    }
};
// @lc code=end

