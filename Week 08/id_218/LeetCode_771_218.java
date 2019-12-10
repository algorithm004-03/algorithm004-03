package leetcode.week8;

/**
 * http://leetcode-cn.com/problems/jewels-and-stones/
 *
 * @author eason.feng at 2019/12/7/0007 13:08
 **/
public class LeetCode_771_218 {

    public int numJewelsInStones(String J, String S) {
        int res = 0;
        if (J == null || "".equals(J) || S == null || "".equals(S)) {
            return res;
        }
        char[] jchs = J.toCharArray();
        char[] schs = S.toCharArray();
        int sLen = schs.length;
        int jLen = jchs.length;
        for (int i = 0; i < sLen; i++) {
            for (int k = 0; k < jLen; k++) {
                char t = jchs[k];
                if (t == schs[i]) {
                    res++;
                }
            }
        }
        return res;
    }

}
