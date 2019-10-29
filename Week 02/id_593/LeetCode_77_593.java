
/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jaryoung
 */
public class LeetCode_77_593 {
    private List<List<Integer>> result = new LinkedList<>();

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     *
     * @param n 最多的数
     * @param k 最多几个数为一组
     * @return 所有组合
     */
    public List<List<Integer>> combineByRecursion(int n, int k) {
        if (n == 0 || k == 0) {
            return Collections.emptyList();
        }
        combineByRecursion(1, n, k, new LinkedList<>());
        return result;
    }

    /**
     * 若组合完成- 添加到输出中。
     * <p>
     * 遍历从 index 到 n的所有整数。
     * <p>
     * 将整数 i 添加到现有组合 curr中。
     * <p>
     * 继续向组合中添加更多整数 :
     * combineByRecursion(i + 1, curr).
     * <p>
     * 将 i 从 curr中移除，实现回溯。
     * <p>
     *
     * @param index   当前位置
     * @param n       最多的数
     * @param k       最多几个数为一组
     * @param current 当前组合
     */
    private void combineByRecursion(int index, int n, int k, LinkedList<Integer> current) {
        // 终止条件又写错了  index == k，脑回路了。
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
        }
        //  n 是从1开始的
        for (int i = index; i < n + 1; ++i) {
            current.add(i);
            combineByRecursion(i + 1, n, k, current);
            // 上面 i + 1，current 传递的是引用，梦境会互相影响了，为了不影响当层梦境，所以这里回退清空状态
            current.removeLast();
        }
    }