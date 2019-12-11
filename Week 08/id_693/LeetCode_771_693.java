package id_693;

import org.junit.jupiter.api.Test;

/**
 * @Author 李雷（KyLin）
 * @Desc 771. 宝石与石头	https://leetcode-cn.com/problems/jewels-and-stones/
 * @Date 2019/12/04
 */
public class LeetCode_771_693 {
    /**
     * 计数排序思想
     */
    class Solution {
        public int numJewelsInStones(String J,String S) {
            //J 是宝石,不重复   S 是我的石头
            boolean[] jElements = new boolean[123];
            for (int i = 0; i < J.length(); i++) {
                jElements[J.charAt(i)] = true;
            }
            int res = 0;
            for (int i = 0; i < S.length(); i++) {
                if (jElements[S.charAt(i)]) {
                    res++;
                }
            }
            return res;
        }
    }

    @Test
    public void test() {
        System.out.println(Integer.valueOf('z'));
    }
}
