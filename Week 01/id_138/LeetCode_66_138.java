/**
 * @author Lukas
 * @since 2019/10/20 22:33
 **/
public class LeetCode_66_138 {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int[] rs = new int[length + 1];

        int temp = 0;
        boolean up = false;//是否存在进位
        for (int i = length - 1; i >= 0; i--) {
            if (i == length - 1) {//个位数加1
                temp = digits[i] + 1;
            } else {
                if (up) {
                    temp = digits[i] + 1;
                } else {
                    temp = digits[i];
                }
            }


            if (temp == 10) {
                rs[i + 1] = 0;
                up = true;
            } else {
                rs[i + 1] = temp;
                up = false;
            }
        }
        if (up) {
            rs[0] = 1;
        }
        if (rs[0] != 0) {
            return rs;
        } else {
            int[] dest = new int[length];
            System.arraycopy(rs, 1, dest, 0, length);
            return dest;
        }
    }

    /**
     * 优化
     * @param digits
     * @return
     */
    public int[] plusOne_best(int[] digits) {
        for (int i = digits.length-1; i >=0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0)//从低位到高位遍历，如果不存在进位则返回当前数组
                return digits;
        }
        //特殊处理  9...99 + 1
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}
