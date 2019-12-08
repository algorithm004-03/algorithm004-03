package test1.Week7;

public class Leetcode_190_638 {
    /**
     * 翻转二进制
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 31;i >= 0;i--){
            res = res |((n >> i) & 1) << (31 - i) ;
        }
        return res;
    }
}
