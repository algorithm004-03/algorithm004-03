class Solution {
//主要思路 n & (n - 1)可以将最后一位1化为0;
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n& = (n - 1);
        }
        return sum;
    }

}