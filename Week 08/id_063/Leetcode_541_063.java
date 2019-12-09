/*

思路
简单字符串处理

 */

class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder ret = new StringBuilder(s);

        int startPos = 0;
        int endPos = 0;
        while (startPos < s.length()) {
            endPos = startPos + k - 1 >= s.length() ? s.length()-1 : startPos + k - 1;

            int l = startPos, r = endPos;
            while (l < r) {
                char t = ret.charAt(l); ret.setCharAt(l, ret.charAt(r)); ret.setCharAt(r, t);
                l++; r--;
            }

            startPos += 2*k;
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("a", 2));
    }
}
