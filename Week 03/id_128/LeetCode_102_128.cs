using System.Collections.Generic;
//BFS one loop with level pushed in queue
public class Solution
{
    public IList<IList<int>> LevelOrder(TreeNode root)
    {
        var result = new List<IList<int>>();

        var queue = new List<Tuple<TreeNode, int>>();
        queue.Add(new Tuple<TreeNode, int>(root, 0));
        while (queue.Count() > 0)
        {
            var node = queue[0].Item1;
            var level = queue[0].Item2;
            queue.RemoveAt(0);
            if (node is null)
            {
                continue;
            }
            if (result.Count() == level)
            {
                result.Add(new List<int>());
            }
            result[level++].Add(node.val);
            if (node.left != null)
                queue.Add(new Tuple<TreeNode, int>(node.left, level));
            if (node.right != null)
                queue.Add(new Tuple<TreeNode, int>(node.right, level));
        }
        return result;
    }
}



//BFS without passing level
public class Solution
{
    public IList<IList<int>> LevelOrder(TreeNode root)
    {
        var result = new List<IList<int>>();
        if (root is null)
        {
            return result;
        }
        var queue = new List<TreeNode>();
        queue.Add(root);

        while (queue.Count() > 0)
        {
            var levelResult = new List<int>();
            var levelQueue = new List<TreeNode>();
            while (queue.Count() > 0)
            {
                var node = queue[0];
                queue.RemoveAt(0);

                levelResult.Add(node.val);
                if (node.left != null) levelQueue.Add(node.left);
                if (node.right != null) levelQueue.Add(node.right);
            }
            queue.AddRange(levelQueue);
            result.Add(levelResult);
        }
        return result;
    }
}

//DFS recursion
public class Solution
{
    public IList<IList<int>> LevelOrder(TreeNode root)
    {
        var result = new List<IList<int>>();
        _DFS(root, 0, result);
        return result;
    }


    private void _DFS(TreeNode node, int level, IList<IList<int>> result)
    {
        if (node is null)
        {
            return;
        }

        if (result.Count() == level)
        {
            result.Add(new List<int>());
        }

        result[level++].Add(node.val);

        _DFS(node.left, level, result);
        _DFS(node.right, level, result);
    }
}

