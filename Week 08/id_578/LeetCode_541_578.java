package com.hand.week8;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/12/8
 */
public class LeetCode_541_578 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int start = 0; start < chars.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, chars.length - 1);
            while (i < j) {
                char tmp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = tmp;
            }
        }
        return new String(chars);
    }
}
