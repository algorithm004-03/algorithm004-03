package Week06;

/**
 * @see <a href="191">https://leetcode-cn.com/problems/number-of-1-bits/submissions/</a>
 * 位1的个数
 */
public class LeetCode_191_558 {
    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    /**
     * 正整数
     */
    public static int hammingWeight_1(int n) {
        int count = 0;
        while (n / 2 != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n /= 2;
        }
        if ((n & 1) == 1) {
            count++;
        }
        return count;
    }

    public static int hammingWeight_2(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n % 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    /**
     * 去掉最低位1
     */
    public static int hammingWeight_3(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 92108;
        // System.out.println(hammingWeight(n));
        System.out.println(hammingWeight_3(0b11111111111111111111111111111101));
    }
}
