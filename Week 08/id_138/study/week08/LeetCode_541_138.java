package study.week08;

/**
 * 反转字符串II
 * @author Lukas
 * @since 2019/12/8 18:58
 **/
public class LeetCode_541_138 {

    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < s.length(); start+=2*k) {//每一步遍历2*k个
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {//处理2*k个元素
                char c = a[i];//辅助数组，用来翻转 s 的一半字符
                a[i++] = a[j];
                a[j--] = c;
            }
        }
        return new String(a);
    }
}
