import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 *
 * 分治法
 *
 * 时间复杂度O(2^n)，空间复杂度O(n)
 *
 * 执行用时 : * 7 ms * , 在所有 java 提交中击败了 * 6.10% * 的用户
 * 内存消耗 : * 36.4 MB * , 在所有 java 提交中击败了 * 72.94% * 的用户
 */
class Leetcode17SolutionOne {
  private List<String> combinationList;
  private Map<Character, char[]> numDict;

  public Leetcode17SolutionOne() {
    this.combinationList = new ArrayList<>();
    this.numDict = new HashMap<>();
  }

  public List<String> letterCombinations(String digits) {
    // init num dict
    numDict.put('2', "abc".toCharArray());
    numDict.put('3', "def".toCharArray());
    numDict.put('4', "ghi".toCharArray());
    numDict.put('5', "jkl".toCharArray());
    numDict.put('6', "mno".toCharArray());
    numDict.put('7', "pqrs".toCharArray());
    numDict.put('8', "tuv".toCharArray());
    numDict.put('9', "wxyz".toCharArray());

    if (digits.isEmpty()) {
      return this.combinationList;
    }

    // recursion
    _generate(digits, "");
    return this.combinationList;
  }

  private void _generate(String digits, String s) {
    // terminator
    if (digits.isEmpty()) {
      // conquer
      this.combinationList.add(s);
      System.out.println(s);
      return;
    }

    // divided and conquer
    char curChar = digits.charAt(0);
    for (char j : this.numDict.get(curChar)) {
//      System.out.printf("j=%c\n", j);
      if (digits.length() <= 1) {
        _generate("", s + j);
      } else {
        _generate(digits.substring(1), s + j);
      }
    }

    // clear up
  }

  public static void main(String[] args) {
    Leetcode17SolutionOne solution = new Leetcode17SolutionOne();
    solution.letterCombinations("234");
  }
}