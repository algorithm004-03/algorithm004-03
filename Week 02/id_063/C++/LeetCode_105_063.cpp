/*
思路
进行递归构建，
找出左子树的前序和中序序列，构建左子树
找出右子树的前序和中序序列，构建右子树
左子树的根 右子树的根 和 当前的根节点共同组成新的树
查找子树的前序序列方法:
preorder[0] 一定是当前的根， 在inorder中找preorder[0]的下标x, x 就是左子树中元素的数量，那么preorder[0]后面跟着x个数值就是左子树的前序序列，
preorder再后面的就是右子树的前序序列
查找子树的中序序列的方法:
inorder序列中下标是x的元素就是根，x左边的就是左子树中序序列，x右边就是右子树的中序序列
*/


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
    TreeNode* buildTree(vector<int>& preorder, int pre_start, int pre_end,
                   vector<int>& inorder, int in_start, int in_end) {
        int rootVal = preorder[pre_start];

        int i;
        for (i = 0; i < inorder.size(); i++) {
            if (inorder[i] == rootVal) {
                break;
            }
        }

        TreeNode* p_left_root = nullptr;
        TreeNode* p_right_root = nullptr;

        if (i > in_start) {
            p_left_root = buildTree(preorder, pre_start+1, pre_start + (i - in_start),
                                    inorder, in_start, i-1);
        }

        if (i < in_end) {
            p_right_root = buildTree(preorder, pre_start + 1 + (i-in_start), pre_end,
                                     inorder, i+1, in_end);
        }

        TreeNode* p_root = new TreeNode(rootVal);
        p_root->left = p_left_root;
        p_root->right = p_right_root;

        return p_root;
    }

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if (preorder.size() == 0) {
            return nullptr;
        }

        return buildTree(preorder, 0, preorder.size()-1, inorder, 0, inorder.size() - 1);
    }
};