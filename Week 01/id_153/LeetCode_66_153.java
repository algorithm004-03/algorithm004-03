/**
 * LeetCode_66_153
 * 
 * @desc LeetCode 66 题 https://leetcode-cn.com/problems/plus-one/
 */
public class LeetCode_66_153 {

  /**
   * 最后一位是 9 的话需要进位，前一位加 1 即可
   * 
   * @param digits
   * @return
   */
  public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      digits[i]++;
      digits[i] = digits[i] % 10;
      if (digits[i] != 0) {
        return digits;
      }
    }
    // 如果是 99、999 这种数组，可以直接初始化一个数组，首位加 1，其余默认为 0
    // 看了网友的题解，茅塞顿开，还有这种操作，我还在一直想怎么处理后面的加 1 操作
    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
  }
}