import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_77_368 {

    /*给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
    https://leetcode-cn.com/problems/combinations/*/

    public static void main(String[] args) {

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0 || n < k) {
            return res;
        }
        LinkedList<Integer> combine = new LinkedList<>();
        findCombinations(res, combine, 1, n, k);
        return res;
    }

    private void findCombinations(List<List<Integer>> res, LinkedList<Integer> combine, int cur, int n, int k) {
        if (combine.size() == k) {
            res.add(new ArrayList<>(combine));
            return;
        }
        for (int i = cur; i <= n - (k - combine.size()) + 1; i++) {
            combine.add(i);
            findCombinations(res, combine, i + 1, n, k);
            combine.removeLast();
        }
    }

    public List<List<Integer>> combineIterator(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0 || k > n) {
            return res;
        }
        // 第一个数字
        for (int i = 1; i <= n - k + 1; i++) res.add(Arrays.asList(i));
        // 之后的数字，知道k个
        for (int j = 2; j <= k; j++) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List list : res) {
                for (int p = (int)list.get(list.size() - 1) + 1; p <= n - (k - j); p++) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(p);
                    temp.add(newList);
                }
            }
            res = temp;
        }
        return res;
    }
}