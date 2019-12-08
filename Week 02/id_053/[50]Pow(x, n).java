//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {//这个判断条件多余
            return 1.0;
        }
        //这个坑最大，要把N 定义成long类型，否则结果不正确
        long N = n;
        if(n < 0) {
            x = 1/x;
            N = -N;

        }
        return fastPow(x,N);
    }
    private double fastPow(double x,long n) {
        if (n == 0) {
            return 1.0;
        }
        double subQuestion = fastPow(x,n/2);
        if (n % 2 ==1) {
            return subQuestion * subQuestion * x;
        }else {
            return subQuestion * subQuestion;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
