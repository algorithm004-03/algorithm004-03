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