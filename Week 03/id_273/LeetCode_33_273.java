//33. 搜索旋转排序数组

//解法1：两个二分法		执行用时击败89%
//思路：先通过logN复杂度的二分查找获取到最小值index, 也就是旋转后的偏移点
//		然后判断target位于旋转后的高位还是低位, 并在高位或低位区间通过二分查找查询target
//时间复杂度：O(logn)
//空间复杂度：O(1)
public int search(int[] nums, int target) {
	if (nums.length == 0) return -1;
	int index = findMinIndex(nums);
	int left = 0;
	int right = nums.length - 1;
	//若target小于等于数组中末尾元素, 说明target位于[index, nums.right - 1]区间
	if (target <= nums[nums.length - 1]) left = index;
	//else 位于[0, index - 1]区间
	else right = index - 1;
	while (left <= right) {
		int mid = (left + right) >> 1;
		if (target == nums[mid]) return mid;
		else if (target > nums[mid]) left = mid + 1;
		else right = mid - 1;
	}
	return -1;
}

private int findMinIndex(int[] nums) {
	int left = 0;
	int right = nums.length - 1;
	while (left < right) {
		int mid = (left + right) >> 1;
		if (nums[mid] > nums[right]) left = mid + 1;
		else right = mid;
	}
	return left;
}


//解法2：一个二分搞定
//思路：先判断mid ~ right部分是有序的还是存在偏移点
//			mid ~ right 有序：说明偏移点一定存在于mid之前
//				若target位于有序区间[mid, right], 且target大于mid的话, 只需要在[mid+1,right]部分寻找target即可	
//				else 去左半部分[0,mid]区间寻找, right = mid;				
//			mid ~ right 无序：说明mid ~ right部分一定存在偏移点
//				若target位于存在偏移点的区间[mid, right], 且target大于mid的话, 只需要在[mid+1, 偏移点Index - 1]的区间寻找target即可
//				同样的,若target位于存在偏移点的区间[mid, right], 且target小于等于right的话, 只需要在[mid + 1, right]区间寻找targe即可
//				(上述两种情况, 都需要移动left = mid + 1)
//				else 去左半部分[0,mid]区间寻找, right = mid;
//时间复杂度O(logN)
//空间复杂度O(1)
//总结：相比起解法1采用的两个二分查找, 该方法的逻辑判断要复杂很多, 要考虑的边界条件也蛮多的, 通过测试后发现两种方法的性能也相差无几,
//		个人的话会更偏向于第一种解法。
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right)/2;
            if (nums[mid] <= nums[right]) { // mid ~ right 部分有序
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {//mid ~ right 部分可能存在偏移点
                if (target > nums[mid] || target <= nums[right]) {//说明target位于mid右侧 且一定不在mid位置
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return (left == right && target != nums[left]) ? -1 : left;
    }
}
//else 当0 ~ mid 存在偏移, 也就意味着mid ~ right是旋转后的低位部分, 若left要向后规约, target必须大于mid