class Solution {
    // 1 的位只能有一个
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n-1) == 0;
    }
}