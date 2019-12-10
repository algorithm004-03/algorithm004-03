package Week07;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @see <a href="387">https://leetcode-cn.com/problems/first-unique-character-in-a-string/</a>
 * 387. 字符串中的第一个唯一字符
 */
public class LeetCode_387_558 {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int len = s.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char key = s.charAt(i);
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            char key = s.charAt(i);
            if (hashMap.getOrDefault(key, 0) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }


}
