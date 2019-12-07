import java.util.Arrays;

/**
 * leetcode 242题
 * 异位词是指两个字符串中含有的字母一样，同时每个字母的数量也一致
 *
 * @author northleaf
 * @create 2019年10月22日
 */
public class LeetCode_242_598 {


    /**
     * 将两个字符串分别放在两个字符数组中，排序后比较数组中的元素是否一致，一致返回true，否则返回false
     * 时间复杂度O(nlogn) 取决于排序的时间
     * 空间复杂度O(n)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {

        //如果字符串长度不一致返回false
        if (s.length() != t.length()) {
            return false;
        }
        //转换为数组
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        //排序
        Arrays.sort(charS);
        Arrays.sort(charT);
        //比较
        for (int i = 0; i < charS.length; i++) {
            if (charS[i] != charT[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 数组
     * 借助一个额外的数组，这个数组只存储26个字母的个数，初始为0
     * 针对S中的每个字母求和，针对T中的每个字母做减法，最后判断数字中是否为非零元素
     * 如果有则返回false
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        //如果字符串长度不一致返回false
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
