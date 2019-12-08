import java.util.ArrayList;
import java.util.List;

public class LeetCode_47_368 {

    /*给定一个可包含重复数字的序列，返回所有不重复的全排列。
    https://leetcode-cn.com/problems/permutations-ii/*/

    public static void main(String[] args) {

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int[] visited = new int[nums.length];
        uniqueSort(nums, visited, res, new ArrayList<Integer>());
        return res;
    }

    private void uniqueSort(int[] nums, int[] visited, List<List<Integer>> res, ArrayList<Integer> currentList) {
        if (currentList.size() == nums.length) {
            res.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) continue;
            visited[i] = 1;
            currentList.add(nums[i]);
            uniqueSort(nums, visited, res, currentList);
            visited[i] = 0;
            currentList.remove(currentList.size() - 1);
        }
    }
}
