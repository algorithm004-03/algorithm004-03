package Week06;

/**
 * @see <a href="190">https://leetcode-cn.com/problems/reverse-bits/</a>
 * 颠倒二进制位
 */
public class LeetCode_190_558 {
    public static int reverseBits_1(int n) {
        String s = Integer.toBinaryString(n);
        int zeroCount = 32 - s.length();
        for (int i = 0; i < zeroCount; i++) {
            s = "0" + s;
        }
        s = new StringBuilder(s).reverse().toString();
        return (int) Long.parseLong(s, 2);
    }

    public static int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) + (n & 1);
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 0b11111111111111111111111111111101;
        System.out.println(reverseBits(n));
    }
}
