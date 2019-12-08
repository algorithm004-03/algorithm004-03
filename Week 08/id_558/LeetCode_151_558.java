package Week07;


import java.util.*;

/**
 * @see <a href="151">https://leetcode-cn.com/problems/reverse-words-in-a-string/</a>
 * 翻转字符串里的单词
 */
public class LeetCode_151_558 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        String[] ss = s.trim().split(" +");
        Collections.reverse(Arrays.asList(ss));
        return String.join(" ", ss);
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(new LeetCode_151_558().reverseWords(s));
    }


}
