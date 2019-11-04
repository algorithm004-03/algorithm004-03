public class Solution
{
    public IList<int> Postorder(Node root)
    {
        var result = new List<int>();
        _Postorder(root, result);
        return result;
    }

    private void _Postorder(Node node, IList<int> result)
    {
        if (node is null)
            return;

        foreach (var child in node.children)
        {
            _Postorder(child, result);
        }
        result.Add(node.val);
    }
}

