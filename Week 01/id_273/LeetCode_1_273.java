//1 两数之和


//暴力解法 通过两次遍历相加即可
//时间复杂度O(n^2)
//空间复杂度O(1)

public int[] twoSum(int[] nums, int target) {
	for(int i = 0;i<nums.length;i++) {
		for(int j = i+1;j<nums.length;j++) {
			if (nums[i]+nums[j] == target) {
				return new int[]{i,j};
			}
		}
	}
	return null;
}


//HashMap
//时间复杂度O(n):只遍历了一次nums,每次遍历在map中查看是否包含key=target-nums[i]
//空间复杂度O(n):随着数组的遍历操作 链表也会put
public int[] twoSum(int[] nums, int target) {
	HashMap map = new HashMap();
	int[] result = new int[2];
	for(int i = 0;i<nums.length;i++) {
		if (map.containsKey(target-nums[i]) {
			result[0] = i;
			result[1] = map.get(target-nums[i]);
			return result;
		}
		nums.put(nums[i],i);
	}
	return result;
}