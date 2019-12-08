import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 括号生成：基本思想，n个位置看成n个格子，每个格子都可以放左括号 和 右括号，
 * 把每种可能的情况都枚举出来，并排除掉其中不合法的摆放即可
 *
 * 时间复杂度O(2^n)，空间复杂度O(n)
 *
 * 执行用时 : * 114 ms * , 在所有 java 提交中击败了 * 5.09% * 的用户
 * 内存消耗 : * 39.7 MB * , 在所有 java 提交中击败了 * 39.05% * 的用户
 */
public class Leetcode22SolutionOne {
  private List<String> parenthesisList;

  public Leetcode22SolutionOne() {
    parenthesisList = new ArrayList<>();
  }

  public List<String> getParenthesisList() {
    return parenthesisList;
  }

  public List<String> generateParenthesis(int n) {
    // 自顶向下编程
    _generate(0, 2 * n, "");
    return this.parenthesisList;
  }

  // 递归生成括号
  private void _generate(int level, int max_level, String s) {
    if (level >= max_level) {
      if (_validParenthesis(s)) {
        this.parenthesisList.add(s);
        System.out.println(s);
      }
      return;
    }

    _generate(level + 1, max_level, s + "(");
    _generate(level + 1, max_level, s + ")");
  }

  // check parenthesis using a stack
  private boolean _validParenthesis(String s) {
    Stack<Character> st = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        st.push(s.charAt(i));
      } else { // ')'
        try {
          char other = st.pop();
          if (other != '(') {
            return false;
          }
        } catch(Exception e) {
          return false;
        }
      }
    }

    return st.isEmpty();
  }

  public static void main(String[] args) {
    Leetcode22SolutionOne solution = new Leetcode22SolutionOne();
    solution.generateParenthesis(3);
  }
}