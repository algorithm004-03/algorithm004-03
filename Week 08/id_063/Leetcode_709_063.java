
/*

简单字符串处理

 */

class Solution {
    public String toLowerCase(String str) {
        StringBuilder builder = new StringBuilder();
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            builder.append((ch >= 'A' && ch <= 'Z') ? (char)(ch - 'A' + 'a') : ch);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().toLowerCase("ABCabc"));
    }
}