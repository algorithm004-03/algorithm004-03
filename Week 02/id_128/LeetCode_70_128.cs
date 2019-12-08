//practice the recursive  template
public class Solution
{
    public int ClimbStairs(int n)
    {
        var temp = new Dictionary<int, int>(n);
        temp[1] = 1;
        temp[2] = 2;
        return _ClimbStairs(n, temp);
    }


    private int _ClimbStairs(int n, IDictionary<int, int> temp)
    {
        if (temp.ContainsKey(n))
        {
            return temp[n];
        }

        temp[n] = _ClimbStairs(n - 1, temp) + _ClimbStairs(n - 2, temp);
        return temp[n];
    }
}
// @lc code
