	class Solution {
		public void moveZeroes(int[] nums) {
			// 当前0的位置
			int zeroPos = -1;

			for (int i = 0; i < nums.length; i++) {
				int num = nums[i];

				if (num == 0) {
					// 记录索引位置
					zeroPos = zeroPos == -1 ? i : zeroPos;
				} else if (num != 0 && zeroPos > -1) {
					// 非0数字放到当前第一个0的位置
					nums[zeroPos] = num;
					nums[i] = 0;

					// 重置0的位置，如果原先zeroPos后面不是0，那么现在一定为0，如果是0，那么正好后移一位
					zeroPos++;
				}
			}

		}
	}