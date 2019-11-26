/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jaryoung
 */
public class LeetCode_46_593 {
    List<List<Integer>> result;

    /**
     * 思路： 递归，回溯
     *
     * @param nums 目标序列
     * @return 返回其所有可能的全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length < 1) {
            return Collections.emptyList();
        }

        result = new ArrayList<>();
        backtrack(nums, new LinkedList<>());
        return result;
    }

    private void backtrack(int[] nums, LinkedList<Integer> numberList) {
        // terminator
        int length = nums.length;
        if (length == numberList.size()) {
            result.add(new ArrayList<>(numberList));
            return;
        }
        // process
        for (int i = 0; i < length; i++) {
            // 只要列表没有出现，就往里面添加
            if (numberList.contains(nums[i])) {
                continue;
            }
            numberList.addLast(nums[i]);
            // drill down
            backtrack(nums, numberList);
            // reverse
            numberList.removeLast();
        }
    }
}