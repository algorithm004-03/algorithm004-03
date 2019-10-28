//15. 三数之和

//解法1 暴力求解
//时间复杂度O(n^3)
//运行超时
public List<List<Integer>> threeSum1(int[] nums) {
	Arrays.sort(nums);
	List<List<Integer>> list = new ArrayList<>();
	for (int i = 0;i<nums.length-2;i++) {
		for (int j = i+1;j<nums.length-1;j++) {
			for (int k = j+1;k<nums.length;k++) {
				if (nums[i]+nums[j]+nums[k] == 0) {
					List<Integer> list2 = new ArrayList<>();
					list2.add(nums[i]);
					list2.add(nums[j]);
					list2.add(nums[k]);
					if (!list.contains(list2)) {
						list.add(list2);
					}
				}
			}
		}

	}
	return list;
}

//解法2 双指针（夹逼法）
//时间复杂度O(n^2)
//空间复杂度O(1)
public List<List<Integer>> threeSum2(int[] nums) {
	Arrays.sort(nums);
	List<List<Integer>> list = new ArrayList<>();
	for (int i = 0;i<nums.length-2;i++) {
		//因为通过排序后 若指针i指向的元素为正数，那么指针m，n指向的元素相加是恒大于nums[i]的
		if (nums[i] > 0) {
			break;
		}
		//指针i指向重复的元素直接跳过即可
		if (i > 0 && nums[i] == nums[i-1]) continue;

		int m = i+1;
		int n = nums.length-1;

		while (m<n) {
			int sum = nums[i]+nums[m]+nums[n];
			//说明m指针需要右移指向更大的元素
			if (sum<0) {
				while (m<n && nums[m] == nums[++m]);
			}
			//同理n指针左移
			else if (sum>0) {
				while (m<n && nums[n] == nums[--n]);
			}
			else {
				list.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[m],nums[n])));
				while (m<n && nums[m] == nums[++m]);
				while (m<n && nums[n] == nums[--n]);
			}
		}
	}
	return list;
}
