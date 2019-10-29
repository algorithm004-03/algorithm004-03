/*
 * 589. N叉树的前序遍历
 */

class Solution {
public:
    vector<int> preorder(Node* root) {
        vector<int> res;

        if(root == NULL)
            return res;
        
		stack<Node*> s;
        s.push(root);
		
        while(!s.empty()) {
            Node* top = s.top();
            s.pop();
            res.push_back(top->val);

            for(int i=top->children.size()-1; i>=0; --i) {
                if(top->children[i])
                    s.push(top->children[i]);
            }
        }

        return res;
    }
};