/*
思路

简单字符串处理

 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        int len = 0;
        StringBuilder ret = new StringBuilder();
        char ch;
        boolean endProc = false;
        for (int j = 0; j <= Integer.MAX_VALUE; j++) {
            if (j >= strs[0].length()) {
                return ret.toString();
            }

            ch = strs[0].charAt(j);

            for (int i = 1; i < strs.length; i++) {
                if (j >= strs[i].length()) {
                    endProc = true;
                    break;
                }

                if (strs[i].charAt(j) != ch) {
                    endProc = true;
                    break;
                }
            }

            if (endProc) {
                break;
            }

            ret.append(ch);
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[] {
                "dog","racecar","car"
        }));
    }
}