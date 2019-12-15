/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        if (s == null) return null;

        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }


    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }

            int start = s.lastIndexOf(' ', i);
            sb.append(" ");
            sb.append(s.substring(start + 1, i + 1));
            i = start - 1;


        }

        if (sb.length() > 0) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }


    public String reverseWords3(String s) {
        if (s == null) return null;

        char[] chars = s.toCharArray();
        int n = chars.length;

        reverse(chars, 0, n - 1);
        reverseWord(chars, n);
        return cleanSpaces(chars, n);

    }

    private void reverseWord(char[] chars, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && chars[i] == ' ') i++;
            while (j < i || j < n && chars[j] == ' ') j++;
            reverse(chars, i, j - 1);
        }
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }


    private String cleanSpaces(char[] chars, int n) {
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && chars[j] == ' ') j++;
            while (j < n && chars[j] != ' ') chars[i++] = chars[j++];
            while (j < n && chars[j] == ' ') j++;

            if (j < n) {
                chars[i++] = ' ';
            }
        }

        return new String(chars).substring(0, i);
    }
}
// @lc code=end

