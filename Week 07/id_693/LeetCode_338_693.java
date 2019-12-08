package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 338. 比特位计数 https://leetcode-cn.com/problems/counting-bits/
 * @Date 2019/11/26
 */
public class LeetCode_338_693 {
    /**
     * 位运算：直接利用位1计数来用，时间复杂度是O(n ^ 32)
     */
    class Solution {
        public int[] countBits(int num) {
            int[] result = new int[num + 1];
            for (int i = 0; i <= num; i++) {
                result[i] = hammingWeight(i);
            }
            return result;
        }

        private int hammingWeight(int n) {
            int count = 0;
            for (int i = 1; i <= 32; i++) {
                if (((n >> i) & 1) == 1) {
                    count++;
                }
            }
            return count;
        }
    }

    /**
     * 位运算2:看的通过的最高效率
     */
    class Solution2 {
        public int[] countBits(int num) {
            int[] result = new int[num + 1];
            for (int i = 1; i <= num; i++) {
                result[i] = result[i & (i - 1)] + 1;
            }
            return result;
        }
    }

    /**
     * 位运算3: 自己思考 2 的幂 - 1
     */
    class Solution3 {
        /*
                        1   1   2
                       11   3   4
                      111   7   8
                     1111   15  16
                    11111   31  32
         */
        public int[] countBits(int num) {
            int[] result = new int[num + 1];
            return result;
        }
    }
}
