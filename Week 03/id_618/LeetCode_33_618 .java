
/**
 * 循环nums获取最小最大值，得到关键位置，然后右移使数组有序，再用二分法，其中第一步时间复杂度位O(n)感觉不好
 * 
 * @author hangwen
 *
 */
class Solution1 {
	public int search(int[] nums, int target) {
		// 找到断点，获取右移的步树，使之成为有序数组
		int rigthMoveStep = this.getRigthMoveStep(nums);
		// 右移,使nums有序
		this.moveRight(nums, rigthMoveStep);

		// 二分查找
		int locate = this.searhBinary(nums, target);
		if (locate > -1) {
			// loacate左移步数
			return this.moveLeft(nums, locate, rigthMoveStep);
		}
		return -1;
	}

	private int getRigthMoveStep(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				return nums.length - 1 - i;
			}
		}

		return 0;
	}

	private int moveLeft(int[] nums, int locate, int step) {
		int len = nums.length;
		if (step == 0 || step == len) {
			return locate;
		}

		int ret = locate - step;
		return ret < 0 ? nums.length + ret : ret;
	}

	private void moveRight(int[] nums, int step) {
		int len = nums.length;
		if (step == 0 || step == len) {
			return;
		}

		swap(nums, 0, len - step - 1);
		swap(nums, len - step, len - 1);
		swap(nums, 0, len - 1);
	}

	private int searhBinary(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		if (target < nums[left] || target > nums[right]) {
			return -1;
		}

		while (left <= right) {
			int mid = (left + right) / 2;
			int midVal = nums[mid];

			if (midVal == target) {
				return mid;
			} else if (midVal < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

	private void swap(int[] nums, int start, int end) {

		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;

			start++;
			end--;
		}
	}
}

/**
 * 用二分法找到最小值所在的位置，将数组分为左右两边,然后分别对左右两边进行二分查找，最多执行3次 O(logn)
 * 
 * @author hangwen
 *
 */
class Solution2 {
	private int ret = -1;

	public int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}

		if (nums.length == 1) {
			return target == nums[0] ? 0 : -1;
		}

		// 利用二分法查找最小值所在的位置
		int minValIndex = this.findMinValIndex(nums, target);
		if (this.ret > -1) {
			// 如果在上述过程中已经找到target，直接返回
			return ret;
		}

		// 在左边的有序数组里寻找
		if (minValIndex > 0) {
			this.ret = this.searhBinary(nums, 0, minValIndex - 1, target);
			if (this.ret > -1) {
				return this.ret;
			}
		}

		// 在右边的有序数组里寻找
		return this.searhBinary(nums, minValIndex, nums.length - 1, target);

	}

	private int findMinValIndex(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int leftVal = nums[left];
			if (leftVal == target) {
				this.ret = left;
				return -1;
			}

			int rightVal = nums[right];
			if (rightVal == target) {
				this.ret = right;
				return -1;
			}

			if (left + 1 == right) {
				return leftVal < right ? left : right;
			}

			int mid = (left + right) / 2;
			int midVal = nums[mid];
			if (midVal == target) {
				this.ret = mid;
				return -1;
			}

			if (midVal < leftVal) {
				right = mid;
			} else if (midVal > rightVal) {
				left = mid;
			} else {
				return left;
			}
		}

		return -1;
	}

	private int searhBinary(int[] nums, int left, int right, int target) {
		if (target < nums[left] || target > nums[right]) {
			return -1;
		}

		while (left <= right) {
			int mid = (left + right) / 2;
			int midVal = nums[mid];

			if (midVal == target) {
				return mid;
			} else if (midVal < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

}
