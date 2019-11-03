//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //暴力解法，遍历nums，对每一个元素，都找剩下的nums里面是否含有target - a，如果存在
        //则返回,时间复杂度为n的平方
//        for (int i = 0;i<nums.length; i++) {
//			for (int j = i+1;j<nums.length;j++) {
//				if (nums[j] == target - nums[i]) {
//					return new int[]{i,j};
//				}
//			}
//		}
//		throw new RuntimeException("不存在此组合");

        //使用哈希表来存储数组中的元素和下标，后面查找的时候是常数时间，因此只需要遍历一次，时间复杂度为O(n)
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length; i++){
            //保存该值，和下标
            map.put(nums[i],i);
        }
        for (int i = 0;i<nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[]{i,map.get(target - nums[i])};
            }
        }
        //2、(第二次提交错误，根本就不该对map进行遍历，因为数组里面可能包含相同的元素，此时会发生覆盖)
        // for (Integer key : map.keySet()) {
        //     //1、(第一次错误)没有考虑到两个数一样的情况，下面的判断不全
        //     // if (map.containsKey(target - key)) {
        //         if (map.containsKey(target - key) && map.get(target - key) != map.get(key)) {

        //         return new int[]{map.get(key),map.get(target - key)};
        //         }

        // }
        //没找到返回空数组
        return new int[0];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
