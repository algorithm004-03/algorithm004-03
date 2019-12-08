package com.ljg.leetcode.week08.a06;

/**
 * ReverseStringII
 */
public class ReverseStringII {

    public static void main(String[] args) {
        ReverseStringII rs2 = new ReverseStringII();
        //String s = "abcdefg";
        //int k = 2;
        String s = "abcd";
        int k = 4;
        String res = rs2.reverseStr(s, k);
        System.out.println("res=" + res);
    }

    public String reverseStr(String s, int k) {
        if (s == null) {
            return s;
        }
        char[] chs = s.toCharArray();
        int len = chs.length;
        for (int i = 0; len - i > 0; i += 2 * k) {
            if (len - i >= k) {
                reverse(chs, i, i + k - 1);
            } else {
                reverse(chs, i, len - 1);
            }
        }
        return new String(chs);
    }

    private void reverse(char[] chs, int start, int end) {
        int i = start;
        int j = end;
        while (i <= j) {
            if (i == j) {
                return;
            }
            char temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
            i++;
            j--;
        }
    }
}