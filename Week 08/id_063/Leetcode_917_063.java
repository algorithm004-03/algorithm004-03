
class Solution {
    private boolean isDigit(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public String reverseOnlyLetters(String S) {
        StringBuilder ret = new StringBuilder(S);

        int l = 0, r = ret.length()-1;
        while (l < r) {
            if (!isDigit(ret.charAt(l))) {
                l++; continue;
            }

            if (!isDigit(ret.charAt(r))) {
                r--; continue;
            }

            char ch = ret.charAt(l); ret.setCharAt(l, ret.charAt(r)); ret.setCharAt(r, ch);
            l++; r--;
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}