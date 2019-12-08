/**
 * 反转字符串II
 * https://leetcode-cn.com/problems/reverse-string-ii/%E2%80%A8/
 */
public class LeetCode_541_588 {

    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
}
