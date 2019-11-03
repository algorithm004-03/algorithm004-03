public class Solution
{

    public IList<IList<int>> LevelOrder(Node root)
    {
        var result = new List<IList<int>>();
        _LevelOrder(root, 0, result);
        return result;
    }

    private void _LevelOrder(Node node, int level, IList<IList<int>> result)
    {
        if (node is null)
        {
            return;
        }

        if (level + 1 > result.Count())
        {
            result.Add(new List<int>());
        }

        result[level++].Add(node.val);

        foreach (var child in node.children)
        {
            _LevelOrder(child, level, result);
        }
    }


}

