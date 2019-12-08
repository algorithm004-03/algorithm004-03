/*
思路
进行DFS，各层节点被遍历到的时候将自己的数值加入到其层数对应的List中，
节点访问顺序并没有要求要按照其层次顺序进行，没必要进行BFS
 */


#include <vector>
using namespace std;

// Definition for a Node.
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

    void dfs(vector<vector<int>>& result, Node* p_cur_node, int level) {
        if (p_cur_node == nullptr) {
            return;
        }

        while (result.size() < level + 1) {
            result.emplace_back();
        }

        result[level].push_back(p_cur_node->val);
        for (Node* p_sub_node : p_cur_node->children) {
            dfs(result, p_sub_node, level + 1);
        }
    }

    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> result;
        dfs(result, root, 0);

        return result;
    }
};