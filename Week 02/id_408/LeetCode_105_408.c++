class Solution {
public:
    map<int, int> idx;
    TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int& pre_idx, int inleft, int inright){
        if(inleft == inright)
            return NULL;
        
        int root_val = preorder[pre_idx];
        TreeNode* root = new TreeNode(root_val);
        
        int index = idx[root_val];
        
        pre_idx++;
        
        root->left = helper(preorder, inorder, pre_idx, inleft, index);
        
        root->right = helper(preorder, inorder, pre_idx, index + 1, inright);
        
        return root;
        
    }
    
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        for(int i = 0; i < inorder.size(); i++){
            idx[inorder[i]] = i;
        }
        int pre_idx = 0;
        return helper(preorder, inorder, pre_idx, 0, inorder.size());
    }
};
