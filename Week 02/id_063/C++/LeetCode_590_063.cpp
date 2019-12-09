#include <vector>
using namespace std;

/*
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

    void dfs(vector<int>& result, Node* p_cur_node) {
        if (p_cur_node == nullptr) {
            return;
        }

        for (Node* p_sub_node : p_cur_node->children) {
            dfs(result, p_sub_node);
        }

        result.push_back(p_cur_node->val);
    }

    vector<int> postorder(Node* root) {
        vector<int> v;
        dfs(v, root);

        return v;
    }
};