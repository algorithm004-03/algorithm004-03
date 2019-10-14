	class Solution {
		public void rotate(int[] nums, int k) {
			int len = nums.length;
			if (k >= len) {
				k = k % len;
			}

			swap(nums, 0, len - k - 1);
			swap(nums, len - k, len - 1);
			swap(nums, 0, len - 1);
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