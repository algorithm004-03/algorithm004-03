package id_693;

import java.util.*;

/**
 * @Desc 77. 组合   https://leetcode-cn.com/problems/combinations/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/26
 */
public class LeetCode_77_693 {

    /*
    给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

    示例:
        输入: n = 4, k = 2
        输出:
        [
          [2,4],
          [3,4],
          [2,3],
          [1,2],
          [1,3],
          [1,4],
        ]

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/combinations
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    //使用数组+递归
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(1, new ArrayList<>(), list, n, k);
        return list;
    }
    private void backtrack(int first, List<Integer> integers, List<List<Integer>> list, int n, int k) {
        if (integers.size() == k) {
            list.add(new ArrayList<>(integers));
            return;
        }
        for (int i = first; i <= n - (k - integers.size()) + 1; i++) {
            integers.add(i);
            backtrack(i + 1, integers, list, n, k);
            integers.remove(integers.size() - 1);
        }
    }

    //使用栈
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack2(1, new ArrayDeque<>(), list, n, k);
        return list;
    }
    private void backtrack2(int first, Deque<Integer> integers, List<List<Integer>> list, int n, int k) {
        if (integers.size() == k) {
            list.add(new ArrayList<>(integers));
            return;
        }
        for (int i = first; i <= n - (k - integers.size()) + 1; i++) {
            integers.offer(i);
            backtrack2(i + 1, integers, list, n, k);
            integers.pollLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_77_693().combine2(4,2));
    }
}
