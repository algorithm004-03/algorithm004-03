/*

思路
双指针前后夹逼，如果两个指针指向的字符不同，跳跃一次，如果至多跳跃一次能够
让两个指针相遇或者错开，说明字符串合法

 */

class Solution {

    private boolean isPalindrome(String s, int start, int end) {
        int l = start, r = end;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++; r--;
        }

        return true;
    }

    public boolean validPalindrome(String s) {
        if (s == null) {
            return false;
        }

        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l+1, r) || isPalindrome(s, l, r-1);
            } else {
                l++; r--;
            }
        }

        return true;
    }
}