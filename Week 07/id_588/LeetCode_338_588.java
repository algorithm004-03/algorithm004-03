/**
 * 比特位计数
 * https://leetcode-cn.com/problems/counting-bits/description/
 */
public class LeetCode_338_588 {

    /**
     * 对于所有的数字，只有两类：
     *
     * 奇数：二进制表示中，奇数一定比前面那个偶数多一个1，因为多的就是最低位的1。
     * 偶数：二进制表示中，偶数中1的个数一定和除以2之后的那个数一样多。因为最低位是0，除以2就是右移一位，也就是把那个0抹掉而已，所以1的个数是不变的。
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 1; i <= num; i ++) {
            // 奇数
            if (1 == (i & 1)) {
                result[i] = result[i - 1] + 1;
            } else {
                // 偶数
                result[i] = result[i / 2];
            }
        }

        return result;
    }
}
