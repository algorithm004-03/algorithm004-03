import java.util.ArrayList;
import java.util.List;

/**
 * SolutionOne加速版
 *
 * 括号生成：基本思想，n个位置看成n个格子，每个格子都可以放左括号 和 右括号，
 * 在生成的过程中就进行排除，而不是等全部生成后再判断序列是否合法，从而加速整
 * 个过程
 *
 * 在生成的过程中，合法性判断：左括号必须<=n，右括号<=左括号
 *
 * 时间复杂度O(2^n)，空间复杂度O(n)
 *
 * 执行用时 : * 12 ms * , 在所有 java 提交中击败了 * 9.12% * 的用户
 * 内存消耗 : * 36.5 MB * , 在所有 java 提交中击败了 * 97.67% * 的用户
 */
public class Leetcode22SolutionTwo {
  private List<String> parenthesisList;

  public Leetcode22SolutionTwo() {
    parenthesisList = new ArrayList<>();
  }

  public List<String> getParenthesisList() {
    return parenthesisList;
  }

  public List<String> generateParenthesis(int n) {
    // 自顶向下编程
    _generate(0, 0, n, "");
    return this.parenthesisList;
  }
  // 递归生成括号
  private void _generate(int left, int right, int max_level, String s) {
    if (left >= max_level && right >= max_level) {
      parenthesisList.add(s);
      System.out.println(s);
      return;
    }
    if (left < max_level) {
      _generate(left + 1, right, max_level, s + "(");
    }
    if (right < left) {
      _generate(left, right + 1, max_level, s + ")");
    }
  }

  public static void main(String[] args) {
    Leetcode22SolutionTwo solution = new Leetcode22SolutionTwo();
    solution.generateParenthesis(3);
  }
}