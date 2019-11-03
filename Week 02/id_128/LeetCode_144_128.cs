public class Solution
{
    public IList<int> PreorderTraversal(TreeNode root)
    {
        var result = new List<int>();
        _ProOrderTraversal(root, result);
        return result;
    }

    private void _ProOrderTraversal(TreeNode node, IList<int> result)
    {
        if (node is null)
        {
            return;
        }
        result.Add(node.val);
        _ProOrderTraversal(node.left, result);
        _ProOrderTraversal(node.right, result);

    }
}

