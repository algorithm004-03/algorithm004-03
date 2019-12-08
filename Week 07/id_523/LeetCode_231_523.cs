public class Solution
{
    public bool IsPowerOfTwo(int n)
    {
        while (n > 0)
        {
            if (n == 1 || n == 2) return true;

            if (n % 2 == 1)
            {
                return false;
            }
            else
            {
                n = n / 2;
            }
        }

        return false;
    }

    public bool IsPowerOfTwo2(int n)
    {
        return n > 0 && (n & (n - 1)) == 0;
    }
}