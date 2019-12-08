/**
 * 从数组最低位逐项拷贝，有进位的话设置标记，并在遍历过程中传递标记
 * 时间复杂度为O(n)，空间复杂度O(1)
 *
 * 未看题解
 *
 * 执行用时 : * 0 ms * , 在所有 java 提交中击败了 * 100.00% * 的用户
 * 内存消耗 : * 35.1 MB * , 在所有 java 提交中击败了 * 38.13% * 的用户
 */
public class Leetcode66SolutionOne {
  public int[] plusOne(int[] digits) {
    boolean allNine = true;

    // 确定数组长度
    for (int i = 0; i < digits.length; ++i) {
      if (digits[i] != 9) {
        allNine = false;
      }
    }

    int[] result;
    if (allNine) {
      result = new int[digits.length + 1];
    } else {
      result = new int[digits.length];
    }

    int resultIdx = result.length - 1;
    int digitIdx = digits.length - 1;
    boolean flag = false;

    // 最低位加1，有进位
    result[resultIdx] = digits[digitIdx];
    result[resultIdx]++;
    if (result[resultIdx] > 9) {
      result[resultIdx] = 0;
      flag = true;
    }
    digitIdx--;
    resultIdx--;

    // 从最低位逐个拷贝
    while (digitIdx >= 0) {
      result[resultIdx] = digits[digitIdx];
      if (flag) {
        if (result[resultIdx] + 1 > 9) {
          result[resultIdx] = 0;
          flag = true;
        } else {
          result[resultIdx]++;
          flag = false;
        }
      }

      digitIdx--;
      resultIdx--;
    }

    // 最高位
    if (resultIdx >= 0) {
      result[resultIdx] = 1;
    }

    return result;
  }
}
