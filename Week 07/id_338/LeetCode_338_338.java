/**
 * @author Leesen
 * @date 2019/12/1 23:30
 */
public class LeetCode_338_338 {
    //x1=(1001011101)
    //x2=(100101110)
    //动态规划 + 最低有效位
    public int[] countBits(int num) {
        //ans[i] 指int i 二进制数中1的个数
        //num+1 是因为ans[0]到ans[num]
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
        return ans;
    }

    //最后设置位的思路也很巧妙, 利用公式 x = x&(x-1)  清零最低位的1
    //https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
    public int[] countBits1(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }
}
