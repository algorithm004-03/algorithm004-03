//169. 求众数

//解法1：HashMap
//思路：参考了LeetCode第一题TwoSum的HashMap思想, 重复出现的数value+1,当判断某个数value > n/2 , return this num;
//时间复杂度O(n)
//空间复杂度O(n)
//总结：一看到这类问题立马就想到了HashMap...虽然效率不高, 但是真的好用... (估计时间浪费在HashMap的操作上了)
public int majorityElement(int[] nums) {
	HashMap<Integer, Integer> map = new HashMap<>();
	for (int i = 0; i<nums.length; i++) {
		if (map.containsKey(nums[i])) {
			int temp = map.get(nums[i]);
			map.put(nums[i],++temp);
			if (map.get(nums[i]) > (nums.length/2)) {
				return nums[i];
			}
			continue;
		}
		map.put(nums[i],1);
	}
	return nums[0];
}

//解法2：分治
//思路：将数组递归折半划分,求出两个区域中的中位数,若左右两边中位数相同直接return , else求出不同的中位数在左/右半部分出现的次数, return次数多的那个
//时间复杂度O(logN)
//空间复杂度O(1)
//总结：和快速排序采用了同样的思想——分治, 由于大部分操作都基于指针而不是对数组本身操作, 因此效率要快上不少。
public int majorityElement(int[] nums) {
	return major(nums, 0, nums.length - 1);
}

private int major(int[] nums, int low, int high) {
	if (low == high) return nums[low];
	int mid = (high - low)/2 + low;
	//求左半部分的众数
	int left = major(nums, low, mid);
	//求
	int right = major(nums, mid + 1, high);

	if (left == right) return left;

	int leftCount = countMethod(nums, left, low, high);
	int rightCound = countMethod(nums, right, low, high);

	return leftCount < rightCound ? right : left;
}

private int countMethod(int[] nums, int num, int low, int high) {
	int count = 0;
	for (int i = low; i<=high; i++) {
		if (nums[i] == num) {
			count++;
		}
	}
	return count;
}

