public class Solution {
    // you need to treat n as an unsigned value
    
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            // 清除n最后一位1
            n = n & (n - 1);
        }
        return count;
    }

    public int hammingWeight1(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }
}