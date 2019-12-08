package com.company.leetcode.editor.cn;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_125 {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            while (left < right && !isValidChar(leftChar)) {
                left++;
                leftChar = s.charAt(left);
            }
            if (left == right) {
                return true;
            }
            char rightChar = s.charAt(right);
            while (left < right && !isValidChar(rightChar)){
                right--;
                rightChar = s.charAt(right);
            }
            if (left == right) {
                return true;
            }
            String leftStr = String.valueOf(leftChar);
            String rightStr = String.valueOf(rightChar);
            if (!leftStr.equalsIgnoreCase(rightStr)){
                return false;
            }
            left++;
            right--;
        }

        return true;

    }

    //字母和数字字符
    private boolean isValidChar(char c){
        boolean b = (c >= '0' && c <= '9')
                || (c >= 'A' && c <= 'Z')
                || (c >= 'a' && c <= 'z');
        return b;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(s.isPalindrome("race a car"));
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
