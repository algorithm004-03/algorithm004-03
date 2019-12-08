/**
 * @author Leesen
 * @date 2019/12/1 23:30
 */
public class LeetCode_190_338 {
    //    思路
//        将给定的二进制数,由低到高位逐个取出
//        然后通过位运算将其放置到反转后的位置
//        将上述结果再次通过运算结合到一起
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // 1. 将给定的二进制数,由低到高位逐个取出
            // 1.1 右移 i 位,
            int tmp = n >> i; //****右移>>
            // 1.2  取有效位
            tmp = tmp & 1;
            // 2. 然后通过位运算将其放置到反转后的位置.
            tmp = tmp << (31 - i);
            // 3. 将上述结果再次通过运算结合到一起
            result |= tmp;
        }
        return result;
    }
}
