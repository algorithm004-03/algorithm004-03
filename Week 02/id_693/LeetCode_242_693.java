package id_693;


import java.util.Arrays;

/**
 * @Desc 242. 有效的字母异位词  https://leetcode-cn.com/problems/valid-anagram/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/21
 */
public class LeetCode_242_693 {
    //暴力破解，直接对字符串排序，然后比较是否相等即可
    public boolean isAnagram(String s, String t) {
        char [] a = s.toCharArray();
        Arrays.sort(a);
        char [] b = t.toCharArray();
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }

    //优化方案：

    public static void main(String[] args) {


        System.out.println(new LeetCode_242_693().isAnagram("asd", "asd"));
        System.out.println(new LeetCode_242_693().isAnagram("asde", "saed"));
        System.out.println(new LeetCode_242_693().isAnagram("anagram", "nagaram"));
    }
}
