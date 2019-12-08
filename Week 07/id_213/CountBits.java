class Solution {
//暴力求解法。通过遍历获取每个数的位1个数存入数组中。
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) 
            ans[i] = popcount(i);
        return ans;
    }
    private int popcount(int x) {
        int count;
        for (count = 0; x != 0; count++) 
        x = x & (x - 1);
        return count;
    }
//动态规划 + 最高有效位
//需要找到状态转移函数 f(x + b) = f(x) + 1; b = 2^m > x;
    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        int i = 0; int b = 1;
        while (b <= num) {
            while (i + b <= num && i < b) {
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;
            b <<= 1;
        }
        return ans;
    }
//DP + 最低有效位
//状态转移函数 有f(x) = f(x/2) + (x mod 2);
    public int[] countBits3(int num) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= num; ++i) 
            ans[i] = ans[i >> 1] + (i & 1);
        retrun ans;
    } 
//DP + 最后设置位
    public int[] countBits4(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i) 
          ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }
}