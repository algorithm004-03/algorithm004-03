package Week07;


/**
 * @see <a href="709">https://leetcode-cn.com/problems/to-lower-case/</a>
 * 转换成小写字母
 */
public class LeetCode_709_558 {

    public static String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        String s = "";
        char[] chars = str.toCharArray();
        for (int c : chars) {
            if (c >= 65 && c <= 90) {
                c = c + 32;
            }
            s += (char)c;
        }
        return s;
    }

    public static void main(String[] args) {
        char c = 'Z';
        System.out.println(toLowerCase("A6l"));
    }


}
