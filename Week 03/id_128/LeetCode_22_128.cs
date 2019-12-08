//dfs
public class Solution
{
    public IList<string> GenerateParenthesis(int n)
    {
        var result = new List<string>();
        _GenerateParentheis(0, 0, n, "", result);
        return result;
    }


    private void _GenerateParentheis(int i, int j, int n, string tempStr, IList<string> result)
    {
        if (j >= n)
        {
            result.Add(tempStr);
            return;
        }

        if (i < n)
        {
            _GenerateParentheis(i + 1, j, n, tempStr + '(', result);
        }
        if (j < i)
        {
            _GenerateParentheis(i, j + 1, n, tempStr + ')', result);
        }
    }
}

//bfs
public class Solution
{
    public IList<string> GenerateParenthesis(int n)
    {
        var result = new List<string>();

        var queue = new List<Tuple<string, int, int>>();
        queue.Add(new Tuple<string, int, int>("(", 1, 0));

        while (queue.Count() > 0)
        {
            var cur = queue[0];
            queue.RemoveAt(0);
            if (cur.Item3 >= n)
            {
                result.Add(cur.Item1);
            }
            if (cur.Item2 < n) queue.Add(new Tuple<string, int, int>(cur.Item1 + "(", cur.Item2 + 1, cur.Item3));
            if (cur.Item3 < cur.Item2) queue.Add(new Tuple<string, int, int>(cur.Item1 + ")", cur.Item2, cur.Item3 + 1));
        }

        return result;
    }
}
