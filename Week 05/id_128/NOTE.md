# NOTE

  
//climb stairs three steps
//0 stair 0
//1 stair 1
//2 stair 2
//3 stair 4
//4 stair 7
public class Solution
{
    public int ClimbStairs(int n)
    {
        if (n < 3) return n;
        if (n == 3) return 4;
        int first = 1;
        int second = 2;
        int third = 4;

        for (int i = 4;i <= n; i++) {
            int fourth = first + second + third;
            first = second;
            second = third;
            third = fourth;
        }
        return third;
    }
}


0   0
1   1
2   1
3   3
4   3
5   3
6   6
f(n) = f(n-1) - 
  0 1 2 3
0 0 0 0 0
1 0 1 0 0
2 0 0 2 0
3 0 0 0 3
4       3
5       3
6       6