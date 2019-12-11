/*

简单字符串处理

 */

class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" +");
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("")) {
                continue;
            }

            ret.append(new StringBuilder(strs[i].trim()).reverse().toString() + " ");
        }

        if (ret.length() > 0) {
            ret.deleteCharAt(ret.length() - 1);
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
    }
}