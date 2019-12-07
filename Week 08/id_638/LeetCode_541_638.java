package test1.Week8;

public class LeetCode_541_637 {

    /**
     * 翻转字符串2
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        int len = s.length();
        if (s == null || len < 2)return s;

        char[] arr = s.toCharArray();
        for (int start = 0; start < arr.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, arr.length - 1);
            while (i < j) {
                char tmp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = tmp;
            }
        }
        return new String(arr);

    }
}
