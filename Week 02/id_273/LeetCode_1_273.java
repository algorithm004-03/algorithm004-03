//1. 两数之和

//解法1：暴力解法 执行用时击败约53%
//思路：通过两次遍历获取到所有不同的组合,比较组合相加是否等于target
//时间复杂度O(n^2)
//空间复杂度O(1)
//总结：虽然是暴力解法,但是通过两次遍历获取到所有不同的组合的这种遍历方式细节要掌握。
public int[] twoSum(int[] nums, int target) {
	for (int i = 0; i < nums.length - 1; i++) {
		for (int j = i + 1; j < nums.length; j++) {
			if (nums[i] + nums[j] == target) {
				return new int[]{i, j};
			}
		}
	}
	return null;
}


//解法2：HashMap  执行用时击败约98%
//思路：遍历nums, 每次遍历判断map中是否存储了target-nums[i]的key, 若已经存在直接取出结果返回, 不存在则将当前nums[i]存入map
//时间复杂度O(n)
//空间复杂度O(n)
//总结：比较典型的空间换时间优化策略,利用了HashMap随机访问高效的特性
public int[] twoSum(int[] nums, int target) {
	HashMap<Integer, Integer> map = new HashMap<>();
	for (int i = 0; i < nums.length; i++) {
		if (map.containsKey(target - nums[i])) {
			return new int[]{i, map.get(target - nums[i])};
		}
		map.put(nums[i], i);
	}
	return null;
}