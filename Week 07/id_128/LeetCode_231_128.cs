//iteration, time out
public class Solution
{
    public bool IsPowerOfTwo(int n)
    {
        if (n < 1)
            return false;
        int a = 1;
        while (a < n)
        {
            a *= 2;
        }
        if (a == n)
            return true;
        return false;
    }
}

//n & n-1   
public class Solution
{
    public bool IsPowerOfTwo(int n)
    {
        if (n < 1)
            return false;
        if ((n & (n - 1)) == 0)
            return true;
        return false;
    }
}

//one liner
public class Solution
{
    public bool IsPowerOfTwo(int n)
    {
        return (n > 0) && (n & (n - 1)) == 0;
    }
}


//one liner, n & -n
public class Solution
{
    public bool IsPowerOfTwo(int n)
    {
        return (n > 0) && (n & (-n)) == n;
    }
}