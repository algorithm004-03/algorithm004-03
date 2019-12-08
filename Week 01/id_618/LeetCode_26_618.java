	class Solution {
		public int removeDuplicates(int[] nums) {
			// 处理特殊情况
			if (nums.length <= 1) {
				return nums.length;
			}

			// 表示每当出现不同数字的计数，也就是最后的返回值
			int count = 1;

			for (int i = 1; i < nums.length; i++) {
				int previous = nums[i - 1];
				int current = nums[i];

				// 如果不一样,不同数字计数+1，并将当前值存放到其应该存在的位置，即count-1的值，例如第2个不同值，其位置就是1
				if (previous != current) {
					count++;
					nums[count - 1] = current;
				}
			}

			return count;
		}
	}