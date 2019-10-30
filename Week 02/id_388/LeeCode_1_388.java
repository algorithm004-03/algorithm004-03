import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> cacheMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (cacheMap.containsKey(nums[i])){
                int[] res = new int[]{cacheMap.get(nums[i]),i};
                return res;
            }
            Integer key = target - nums[i];
            cacheMap.put(key,i);
        }
        int[] res = new int[0];
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
