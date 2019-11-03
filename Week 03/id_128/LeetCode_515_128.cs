//bfs
public class Solution
{
    public IList<int> LargestValues(TreeNode root)
    {
        if (root is null) return new List<int>();
        return _BFS(root);
    }

    private IList<int> _BFS(TreeNode root)
    {
        var result = new List<int>();
        var queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        var level = 0;

        while (queue.Count() > 0)
        {
            var size = queue.Count();
            while (size-- > 0)
            {
                var node = queue.Dequeue();
                if (level == result.Count()) result.Add(Int32.MinValue);
                if (node.val > result[level]) result[level] = node.val;
                if (node.left != null) queue.Enqueue(node.left);
                if (node.right != null) queue.Enqueue(node.right);
            }
            level += 1;
        }
        return result;
    }
}


//dfs
public class Solution
{
    public IList<int> LargestValues(TreeNode root)
    {
        var result = new List<int>();
        if (root is null) return new List<int>();
        _DFS(root, 0, result);
        return result;
    }

    private IList<int> _DFS(TreeNode node, int level, IList<int> result)
    {
        if (node is null)
            return;
        if (result.Count() == level)
            result.Add(int32.MinValue);
        if (node.val > result[level])
            result[level++] = node.val;
        _DFS(node.left, level, result);
        _DFS(node.right, level, result);

    }
}