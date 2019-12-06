package id_713.practise;

/**
 * 58. 最后一个单词的长度
 */
public class LeetCode_58_LengthOfLastWord {
    /*
    给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

    如果不存在最后一个单词，请返回 0 。

    说明：一个单词是指由字母组成，但不包含任何空格的字符串。

    示例:

    输入: "Hello World"
    输出: 5


    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/length-of-last-word
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    */

    public int lengthOfLastWord(String s) {
        if (s == null) return 0;
        s = s.trim();
        if (s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                return s.length() - 1 - i;
        }

        return s.length();
    }

    public int lengthOfLastWord2(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim();
        int lastSpace = s.lastIndexOf(" ");
        return s.length() - 1 - lastSpace;
    }

}
