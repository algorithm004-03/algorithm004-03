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

