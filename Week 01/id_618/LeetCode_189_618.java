	class Solution {
		public void rotate(int[] nums, int k) {
			int len = nums.length;
			if (k >= len) {
				k = k % len;
			}

			if (k == 0) {
				return;
			}

			// 移位计数
			int count = 0;
			// 每一轮起始
			int start = 0;

			// 当前位置
			int current = start;
			// 当前位置的值
			int currentVal = nums[current];

			do {
				// 计算移位目标
				int target = (current + k) % len;

				// 将currentVal放入目标位置，目标原值存入temp
				int temp = nums[target];
				nums[target] = currentVal;

				// 移位计数+1
				count++;

				current = target;
				currentVal = temp;

				// 如果回到起点，则start+1,开始下一轮
				if (current == start) {
					start++;
					current = start;
					currentVal = nums[current];
				}

			} while (count < len);// 所有元素都移动后终止
		}
	}