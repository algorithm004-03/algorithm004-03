/**
 * 反转字符串II
 *
 * 执行用时 : * 2 ms * , 在所有 java 提交中击败了 * 55.35% * 的用户
 * 内存消耗 : * 37.3 MB * , 在所有 java 提交中击败了 * 97.74% * 的用户
 */
public class Leetcode541 {
  public String reverseStr(String s, int k) {
    if (s == null) {
      return null;
    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < s.length(); i += 2 * k) {
      result.append(reverse(s.substring(i, Math.min(i + k, s.length()))));
      result.append(s.substring(Math.min(i + k, s.length()), Math.min(i + 2 * k, s.length())));
    }

    return result.toString();
  }

  // 翻转字符串
  private String reverse(String s) {
    if (s == null) {
      return null;
    }

    StringBuilder result = new StringBuilder();

    for (int i = s.length() - 1; i >= 0; i--) {
      result.append(s.charAt(i));
    }

    return result.toString();
  }

  public static void main(String[] args) {
    String s = "hello, world!";
    Leetcode541 so = new Leetcode541();
    System.out.println(so.reverse(s));

    s = "a";
    System.out.println(so.reverse(s));
  }
}
