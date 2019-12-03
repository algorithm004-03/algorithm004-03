import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_46_368 {

    /*给定一个没有重复数字的序列，返回其所有可能的全排列。
    https://leetcode-cn.com/problems/permutations/*/

    public static void main(String[] args) {

    }

    public List<List<Integer>> permuteIterator(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            res.add(Arrays.asList(nums[i]));
        }
        for (int j = 1; j < nums.length; j++) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List list : res) {
                for (int k = 0; k < nums.length; k++) {
                    if (!list.contains(nums[k])) {
                        List<Integer> newList = new ArrayList<>(list);
                        newList.add(nums[k]);
                        temp.add(newList);
                    }
                }
            }
            res = temp;
        }
        return res;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int[] visited = new int[nums.length];
        List<Integer> row = new ArrayList<>();
        allSort(res, nums, row, visited);
        return res;
    }

    private void allSort(List<List<Integer>> res, int[] nums, List<Integer> row, int[] visited) {
        if (row.size() == nums.length) {
            res.add(new ArrayList<>(row));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            row.add(nums[i]);
            allSort(res, nums, row, visited);
            visited[i] = 0;
            row.remove(row.size() - 1);
        }
    }
}
