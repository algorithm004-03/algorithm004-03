
/**
 * https://leetcode-cn.com/problems/decode-ways/
 * 题号：91
 * 题目：解码方法
 */


class Solution {
    public int numDecodings5(String s) {
      int len = s.length();
      int end = 1;
      int cur = 0;
      if (s.charAt(len - 1) != '0') {
          cur = 1;
      }
      for (int i = len - 2; i >= 0; i--) {
          if (s.charAt(i) == '0') {
              end = cur;//end 前移
              cur = 0;
              continue;
          }
          int ans1 = cur;
          int ans2 = 0;
          int ten = (s.charAt(i) - '0') * 10;
          int one = s.charAt(i + 1) - '0';
          if (ten + one <= 26) {
              ans2 = end;
          }
          end = cur; //end 前移
          cur = ans1 + ans2;

      }
      return cur;
    }
}