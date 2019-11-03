//15. 三数之和

//解法1：暴力求解
//思路：类似于两数之和的暴力求解,都是通过遍历获取不重复的三数组合,然后观察相加后是否等于0
//时间复杂度O(n^3)
//总结：虽然提交不通过,但还是一再强调,学会获取不重复元素组合的遍历方式
public List<List<Integer>> threeSum1(int[] nums) {
	Arrays.sort(nums);
	List<List<Integer>> res = new ArrayList<>();
	for (int i = 0; i<nums.length-2; i++) {
		for (int j = i+1; j<nums.length-1; j++) {
			for (int k = j+1; k<nums.length; k++) {
				List<Integer> list = new ArrayList<>();        
				if (nums[i] + nums[j] + nums[k] == 0) {
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					if (!res.contains(list)) {
						res.add(list);
					}
				}
			}
		}
	}
	return res;
}

//解法2:双指针夹逼法
//思路：遍历nums,每次遍历固定一个i指针,然后在i指针之后的数组两端设置左、右指针。
//		当指针所指向的三个元素相加<0,左指针右移寻找更大的元素
//		当指针所指向的三个元素相加>0,右指针左移寻找更小的元素
//		当指针所指向的三个元素相加=0,获取到结果,存放至list
//时间复杂度O(n^2)
//空间复杂度O(1)
//总结：除开总体解题思路比较大开脑洞以外,一些细节方面的处理也是让人头皮发麻...主要还是在于理解左右夹逼的思想吧
public List<List<Integer>> threeSum(int[] nums) {
	Arrays.sort(nums);
	List<List<Integer>> list = new ArrayList<>();
	for (int i = 0; i<nums.length-2; i++) {
		//排序后,若指针i指向的元素为正数,那么永远不可能存在三数之和等于0的结果
		if (nums[i] > 0) {
			break;
		}
		//若当前元素等于上一个元素,直接跳过当前遍历,i>0是为了避免数组越界异常
		if (i > 0 && nums[i] == nums[i-1]) {
			continue;
		}
		int left = i+1;
		int right = nums.length-1;

		while (left < right) {
			int sum = nums[i] + nums[left] + nums[right];
			if (sum == 0) {
				list.add(Arrays.asList(nums[i], nums[left], nums[right]));
				//left指针移动前检查是否存在重复元素
				while (left<right && nums[left] == nums[left+1]) {
					left++;
				}
				//right指针移动前检查是否存在重复元素
				while (left<right && nums[right] == nums[right-1]) {
					right--;
				}
				left++;
				right--;
			} else if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}
	}
	return list;
}
