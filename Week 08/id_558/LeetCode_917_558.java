package Week07;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @see <a href="917">https://leetcode-cn.com/problems/reverse-only-letters/submissions/</a>
 * 仅仅反转字母
 */
public class LeetCode_917_558 {

    public String reverseOnlyLetters(String S) {
        StringBuilder ans = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); ++i) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j))) j--;
                ans.append(S.charAt(j--));
            } else {
                ans.append(S.charAt(i));
            }
        }
        return ans.toString();
    }

}
