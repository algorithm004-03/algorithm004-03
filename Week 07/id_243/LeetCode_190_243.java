/**
 * @author eazonshaw
 * @date 2019/12/1  0:17
 */
public class LeetCode_190_243 {

    public int reverseBits(int n) {
        int rs = 0;
        for(int i = 0;i < 32;i++){
            rs = (rs << 1) + (n & 1);
            n = n >> 1;
        }
        return rs;
    }

}
