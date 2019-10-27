	class Solution {
		public void merge(int[] nums1, int m, int[] nums2, int n) {
			if (nums2 == null || n == 0) {
				return;
			}

			// 遍历nums2，从最大值开始
			for (int i = n - 1; i > -1; i--) {
				int num2 = nums2[i];
				if (m == 0) {
					// 特殊情况，直接填充
					nums1[i] = num2;
					continue;
				}

				// nums1中的最大值
				int num1Max = nums1[m - 1];
				if (num2 >= num1Max) {
					// 比num1最大值大，直接填充
					nums1[m + i] = num2;
				} else {
					// 将num1Max填充，用num2顶替其位置
					nums1[m + i] = num1Max;
					nums1[m - 1] = num2;

					// 如有必要，将m-1位置的数字前移
					move(nums1, m);
				}
			}

		}

		/**
		 * 尝试将m-1位置的数字移动，直到nums1数组有序
		 * 
		 * @param nums1
		 * @param m
		 */
		private void move(int[] nums1, int m) {
			int last = nums1[m - 1];

			for (int i = m - 2; i > -1; i--) {
				if (last > nums1[i]) {
					break;
				}

				nums1[i + 1] = nums1[i];
				nums1[i] = last;
			}
		}
	}