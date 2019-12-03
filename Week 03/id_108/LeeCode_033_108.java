package study;

public class LeeCode_033_108 {

	public static int SearchNode(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0;
		int right = nums.length - 1;
		int mid;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			// 前半部分有序,注意此处用小于等于
			if (nums[left] <= nums[mid]) {
				// target在前半部分
				if (target >= nums[left] && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (target <= nums[right] && target > nums[mid]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}

		}
		return -1;

	}
	  public static void main(String[] args) {
	        int ret = new LeeCode_033_108().SearchNode(new int[] {4, 5, 6, 7, 0, 1, 2},0);
	        System.out.println(ret);
	    }
}
