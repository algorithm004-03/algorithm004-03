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

//解法2：分治		执行用时击败100%
//思路：将数组递归折半划分,求出两个区域中的中位数,若左右两边中位数相同直接return , else求出不同的中位数在左/右半部分出现的次数, return次数多的那个
//时间复杂度O(nlogN)
//空间复杂度O(logN)
//总结：和快速排序采用了同样的思想——分治, 由于大部分操作都基于指针而不是对数组本身操作, 因此效率要快上不少。
public int majorityElement(int[] nums) {
	return recur(nums, 0, nums.length - 1);
}

private int recur(int[] nums, int low, int high){
	if (low >= high) return nums[low];
	int mid = (high - low)/2 + low;
	int left = recur(nums, low, mid);
	int right = recur(nums, mid + 1, high);
	//左半区和右半区的众数相同
	if (left == right) return left;
	//若不相同, 计算left和right在当前low~high出现的次数
	int leftCount = countMethod(nums, left, low, high);
	int rightCount = countMethod(nums, right, low, high);
	return leftCount < rightCount ? right : left;
}

private int countMethod(int[] nums, int num, int low, int high) {
	int count = 0;
	for (int i = low; i <= high; i++) {
		if (nums[i] == num) count++;
	}
	return count;
    }
}

//解法3：迭代计数法		执行用时击败100%
//思路：设置一个major用来记录当前的众数, count用于计数
//		遍历数组, 每当遇到与major相同的元素时count++
//		遇到与major不同的count--
//			若count此时已经为0, 那么众数需要更换至当前nums[i], count++
//时间复杂度O(n)
//空间复杂度O(1)
public int majorityElement(int[] nums) {
	int major = nums[0];
	int count = 1;
	for (int i = 1; i < nums.length; i++) {
		if (count == 0) {        
			major = nums[i];
			count++;
		} 
		else if (nums[i] == major) count++;
		else count--;
	}
	return major;
}

//解法4：排序取中
//思路：根据题目要求, 众数出现次数必须大于数组长度N, 那么排序过后位于数组index = nums.length/2的元素必定就是众数
//时间复杂度：O(nlogN)
//空间复杂度：O(1)
public int majorityElement(int[] nums) {
	Arrays.sort(nums);
	return nums[nums.length/2];
}

