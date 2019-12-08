/**
 * @author northleaf
 * @create 2019年11月26日
 */
public class LeetCode_190_598 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int res = 0;

        //移动32次
        for (int i = 0; i < 32; i++) {
            //左移一位
            res = res << 1;
            //取最后一个有效位，与1相与后，再与res 相加
            //n与1的的意思是保留最后一移
            res =res + (n & 1);
            //将n右移一位，也即舍弃最后一痊
            n = n >> 1;
        }

        return res;

    }
}
