import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; ++k) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum > 0) {
                    j--;
                    while (i < j && nums[j] == nums[j + 1]) j--;
                } else if (sum < 0) {
                    i++;
                    while (i < j && nums[i] == nums[i - 1]) i++;
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    j--; i++;
                    while (i < j && nums[j] == nums[j + 1]) j--;
                    while (i < j && nums[i] == nums[i - 1]) i++;
                }
            }
        }
        return result;

    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                int target = 0 - nums[i] - nums[j];
                if (map.containsKey(target) && map.get(target) > j) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], target)));
                    // 因为map在put时会覆盖重复元素，所以直接get可以获取重复元素的最后一个索引
                    j = map.get(nums[j]);
                }
                i = map.get(nums[i]);
            }
        }
        return result;
    }
    /**
     * 暴力法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                for (int k = j + 1; k < nums.length; ++k) {
                    if (i > 0 && nums[i] == nums[i - 1]) continue;
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    }
                }
            }
        }
        return result;
    }
}