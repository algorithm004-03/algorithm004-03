/*
 * 429. N叉树的层序遍历
 */

class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;

        if(root == NULL)
            return res;
        
        queue<Node*> q;
        q.push(root);

        while(!q.empty()) {
            vector<int> temp;
            int size = q.size();

            for(int i=0; i<size; ++i) {
                Node* curNode = q.front();
                q.pop();
                temp.push_back(curNode->val);
                for(auto child : curNode->children)
                    q.push(child);
            }

            res.push_back(temp);
        }

        return res;
    }
};