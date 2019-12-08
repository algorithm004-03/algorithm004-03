/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */

// @lc code=start

// 通过最低有效位来获得状态转移函数。观察x和 x' = x / 2的关系：

// x = (1001011101)_2 = (605)_10
// x'=(1001011101)_2 =(605)_10
// 可以发现 x和'x 只有一位不同，这是因为x'可以看做 xx 移除最低有效位的结果。

// 这样，我们就有了下面的状态转移函数：
// P(x)=P(x/2)+(xmod2)

class Solution {
    public int[] countBits(int num) {
        int []ans = new int[num+1];
        for(int i=1;i<=num;++i){
            ans[i] = ans[i>>1] + (i&1);
            //x/2 == x>>1 
            //x%2 == x&1;
        }
        return ans;
    }
}
// @lc code=end

