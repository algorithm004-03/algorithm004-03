package id_338;

/**
 * @author Leesen
 * @date 2019/12/8 23:09
 */
public class LeetCode_344_338 {
    public void reverseString(char[] s) {
        if (s.length == 0) return;
        for (int i=0, j=s.length-1; i<j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
