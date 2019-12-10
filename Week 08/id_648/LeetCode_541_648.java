/**
 * @Date 2019/12/8
 **/
public class LeetCode_541_648 {
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

    public static void main(String[] args) {
        LeetCode_541_648 leetCode_541_648 = new LeetCode_541_648();
        String s = "abcdefg";
        int k =2;
        String str = leetCode_541_648.reverseStr(s,k);
        System.out.println(str);
    }
}
