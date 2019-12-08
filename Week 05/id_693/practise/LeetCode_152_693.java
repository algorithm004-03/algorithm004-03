package id_693.practise;

import org.junit.Assert;

/**
 * @Desc 152. 乘积最大子序列	https://leetcode-cn.com/problems/maximum-product-subarray/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/14
 */
public class LeetCode_152_693 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int num : nums) {
            if (num < 0) {
                imax ^= imin;
                imin ^= imax;
                imax ^= imin;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);
            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        Assert.assertEquals(6, new LeetCode_152_693().maxProduct(new int[]{2, 3, -2, 4}));
        Assert.assertEquals(0, new LeetCode_152_693().maxProduct(new int[]{-2, 0, -1}));
    }
}
