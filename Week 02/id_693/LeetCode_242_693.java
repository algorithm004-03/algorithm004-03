package id_693;


import java.util.Arrays;

/**
 * @Desc 242. 有效的字母异位词  https://leetcode-cn.com/problems/valid-anagram/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/21
 */
public class LeetCode_242_693 {
    //暴力破解，直接对字符串排序，然后比较是否相等即可
    public boolean isAnagram(String s,String t) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        char[] b = t.toCharArray();
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }

    //优化方案：采用哈希映射(标记法)，直接把字符映射到数组，然后再循环一次看是否为0；  空间上，优于上面
    //解释：就是一个负责+ 一个负责-，最后在循环看是否都是0，否则就不对
    public boolean isAnagram2(String s,String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] result = new int[26];
        for (int i = 0; i < s.length(); i++) {
            result[s.charAt(i) - 'a']++;
            result[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_242_693().isAnagram("asd","asd") == true);
        System.out.println(new LeetCode_242_693().isAnagram("asde","saed") == true);
        System.out.println(new LeetCode_242_693().isAnagram("asdbe","saedc") == false);
        System.out.println(new LeetCode_242_693().isAnagram("anagram","nagaram") == true);

        System.out.println(new LeetCode_242_693().isAnagram2("asd","asd") == true);
        System.out.println(new LeetCode_242_693().isAnagram2("asde","saed") == true);
        System.out.println(new LeetCode_242_693().isAnagram2("asdbe","saedc") == false);
        System.out.println(new LeetCode_242_693().isAnagram2("anagram","nagaram") == true);
    }
}
