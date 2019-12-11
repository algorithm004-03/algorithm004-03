import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode_78_368 {

    /*给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
    说明：解集不能包含重复的子集。
    https://leetcode-cn.com/problems/subsets/*/

    public static void main(String[] args) {

    }

    public List<List<Integer>> subsetsIterator(int[] nums) {
        // iterator
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.emptyList());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List list : res) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(nums[i]);
                temp.add(newList);
            }
            res.addAll(temp);
        }
        return res;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        subset(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private void subset(List<List<Integer>> res, ArrayList<Integer> currentList, int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(currentList));
            return;
        }
        // 二分法：不添加当前元素
        subset(res, currentList, nums, index + 1);
        currentList.add(nums[index]);
        subset(res, currentList, nums, index + 1);
        currentList.remove(currentList.size() - 1);
    }
}
