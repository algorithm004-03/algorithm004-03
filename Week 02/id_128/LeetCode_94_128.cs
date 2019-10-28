
public class Solution
{
    public IList<int> InorderTraversal(TreeNode root)
    {
        var result = new List<int>();
        _InorderTraversal(root, result);
        return result;
    }

    private void _InorderTraversal(TreeNode node, IList<int> result)
    {
        if (node is null)
            return;
        _InorderTraversal(node.left, result);
        result.Add(node.val);
        _InorderTraversal(node.right, result);
    }

}

