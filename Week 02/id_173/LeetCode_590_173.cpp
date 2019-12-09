/*
 * 590. N叉树的后序遍历
 */

class Solution {
public:
    vector<int> postorder(Node* root) {
        vector<int> res;      
        
        if(root == NULL)
            return res;
        
        stack<pair<Node*, int>> s;
        s.push(make_pair(root, 0));

        while(!s.empty()) {
            pair<Node*, int> top = s.top();
            
            if(top.second == 1) {
                s.pop();
                res.push_back(top.first->val);
            }
            else {
                s.top().second = 1;
                for(int i=(top.first->children.size())-1; i>=0; --i) {
                    s.push(make_pair(top.first->children[i], 0));
                }
            }
        }

        return res;
    }
};