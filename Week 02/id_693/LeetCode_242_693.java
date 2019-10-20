package id_693;

import java.util.Arrays;

/**
 * @Desc 242. 有效的字母异位词  https://leetcode-cn.com/problems/valid-anagram/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/21
 */
public class LeetCode_242_693 {
    //暴力破解
    public boolean isAnagram(String s, String t) {
        char [] a = s.toCharArray();
        Arrays.sort(a);
        char [] b = t.toCharArray();
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_242_693().isAnagram("asd", "asd"));
        System.out.println(new LeetCode_242_693().isAnagram("asde", "saed"));
        System.out.println(new LeetCode_242_693().isAnagram("anagram", "nagaram"));
    }
}
