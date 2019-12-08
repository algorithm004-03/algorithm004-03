//loop and right shift the number
public class Solution
{
    public int HammingWeight(uint n)
    {
        var count = 0;
        for (int i = 0; i < 32; i++)
        {
            if ((n & 1) == 1)
                count++;
            n = n >> 1;
        }
        return count;
    }
}

//loop and left shift the mask
public class Solution
{
    public int HammingWeight(uint n)
    {
        uint mask = 1;
        int count = 0;
        for (int i = 0; i < 32; i++)
        {
            if ((n & mask) > 0)
            {
                count++;
            }

            mask = mask << 1;
        }
        return count;
    }
}


//n & (n-1)
public class Solution
{
    public int HammingWeight(uint n)
    {
        var count = 0;
        while (n > 0)
        {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}