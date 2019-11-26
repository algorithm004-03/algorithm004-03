class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode* res=NULL;
        helper(root,p,q,res);
        return res;
    }
    bool helper(TreeNode* root,TreeNode* p,TreeNode* q,TreeNode* &res)
    {
        if(!root) return false;
        bool left=helper(root->left,p,q,res);
        bool right=helper(root->right,p,q,res);
        bool self=root==p||root==q;
        if((left&&right)||(self&&(left||right)))res=root;
        return left||right||self;
    }
};

