package leetcode.week7;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 * https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
 *
 * @author eason.feng at 2019/12/1/0001 15:19
 **/
public class LeetCode_338_218 {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
