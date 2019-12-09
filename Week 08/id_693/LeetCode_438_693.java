package id_693;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 李雷（KyLin）
 * @Desc 438. 找到字符串中所有字母异位词	https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * @Date 2019/12/05
 */
public class LeetCode_438_693 {
    /**
     * 暴力破解，直接移动窗体思维（AC） 效率低下
     */
    class Solution {
        public List<Integer> findAnagrams(String s,String p) {
            List<Integer> result = new ArrayList<>();
            char[] sChars = s.toCharArray();
            char[] pChars = p.toCharArray();
            Arrays.sort(pChars);
            String pp = String.valueOf(pChars);
            for (int i = 0; i <= (sChars.length - pChars.length); i++) {
                System.arraycopy(sChars,i,pChars,0,pChars.length);
                Arrays.sort(pChars);
                if (pp.equals(String.valueOf(pChars))) {
                    result.add(i);
                }
            }
            return result;
        }
    }

    /**
     * 淫技-值得思考
     */
    class Solution2 {
        public List<Integer> findAnagrams(String s, String p) {
            //转化为char array
            char[] s_arr = s.toCharArray();
            char[] p_arr = p.toCharArray();
            List<Integer> list = new ArrayList<>();

            //定义两个hash数组
            char[] s_letter = new char[26]; // 滑动窗口hash
            char[] p_letter = new char[26]; //目标数组hash
            //hash p数组
            for(int i = 0; i < p_arr.length;i++){
                p_letter[p_arr[i] - 'a']++;
            }
            //滑动窗口
            int left = 0;
            int right = 0;
            //当窗口右边出界 则退出
            while (right < s_arr.length){
                //获取当前最右边的字符的hash值
                int current_char_index = s_arr[right++] - 'a';
                //当前最优字符加入hash
                s_letter[current_char_index]++;

                //当前字符的hash值 大于 目标数组（溢出） 1.当前字符不在目标数组中 2.当前字符有重复数组 左边界右移缩小窗口
                //主要技巧点 可以进行手动验证
                while (p_letter[current_char_index] < s_letter[current_char_index]){
                    s_letter[s_arr[left++] - 'a']--;
                }
                //当出现窗口大小等于目标数组的大小的时候 匹配成功+1
                if(right - left == p_arr.length){
                    list.add(left);
                }
            }
            return list;
        }
    }

    @Test
    public void test() {
        System.out.println(new LeetCode_438_693().new Solution2().findAnagrams("cbaebabacd","abc"));
    }
}
