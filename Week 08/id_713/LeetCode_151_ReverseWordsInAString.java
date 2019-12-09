package id_713;

import java.util.Arrays;
import java.util.Collections;

/**
 * 151. 翻转字符串里的单词
 */
public class LeetCode_151_ReverseWordsInAString {

    /*
    给定一个字符串，逐个翻转字符串中的每个单词。



    示例 1：

    输入: "the sky is blue"
    输出: "blue is sky the"

    示例 2：

    输入: "  hello world!  "
    输出: "world! hello"
    解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

    示例 3：

    输入: "a good   example"
    输出: "example good a"
    解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。



    说明：

        无空格字符构成一个单词。
        输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
        如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。



    进阶：

    请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public String reverseWords(String s) {
        if (s == null) return null;

        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }


    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }

            int start = s.lastIndexOf(' ', i);
            sb.append(" ");
            sb.append(s.substring(start + 1, i + 1));
            i = start - 1;


        }

        if (sb.length() > 0) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }


    public String reverseWords3(String s) {
        if (s == null) return null;

        char[] chars = s.toCharArray();
        int n = chars.length;

        reverse(chars, 0, n - 1);
        reverseWord(chars, n);
        return cleanSpaces(chars, n);

    }

    private void reverseWord(char[] chars, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && chars[i] == ' ') i++;
            while (j < i || j < n && chars[j] == ' ') j++;
            reverse(chars, i, j - 1);
        }
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }


    private String cleanSpaces(char[] chars, int n) {
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && chars[j] == ' ') j++;
            while (j < n && chars[j] != ' ') chars[i++] = chars[j++];
            while (j < n && chars[j] == ' ') j++;

            if (j < n) {
                chars[i++] = ' ';
            }
        }

        return new String(chars).substring(0, i);
    }

}
