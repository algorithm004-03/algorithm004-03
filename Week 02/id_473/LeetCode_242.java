import java.util.Arrays;

/**
 * 242. 有效字母异位词
 * @Author CJ
 * @create 2019/10/27
 */

public class LeetCode_242 {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
    //字母排序
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        //System.out.println("s排序后:" + String.valueOf(s1));
        char[] t1 = t.toCharArray();
        Arrays.sort(t1);
        //System.out.println("t排序后:" + String.valueOf(t1));
        return String.valueOf(s1).equals(String.valueOf(t1));
    }
}