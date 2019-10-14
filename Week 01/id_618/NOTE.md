### 第三课课后习题

#### 删除排序数组中的重复项

直观的想法非常简单，遇到相邻重复的元素，则后续元素都往前移动一位，简单暴力，但是马上就能意识到这个肯定是个比较糟糕的解法，时间复杂度为O(n²)。

```
   class Solution {
		public int removeDuplicates(int[] nums) {
			// 处理特殊情况
			if (nums.length <= 1) {
				return nums.length;
			}

			// 有重复则减去一个，最后返回len
			int len = nums.length;

			for (int i = 1; i < len; i++) {
				int previous = nums[i - 1];
				int current = nums[i];

				// 如果相邻两个数一样，则后续的都往前移动一位
				if (previous == current) {
					for (int j = i + 1; j < len; j++) {
						nums[j - 1] = nums[j];
					}

					// 移动后索引需要往前一格，len也往前一格，避免尾部不需要的判断
					i--;
					len--;
				}
			}

			return len;
		}
	}
```

要改善时间复杂度，关键在于如何减少迭代，开始的确饶了弯路，后来还是看了官方题解，有这么一点体会，上述解法本质在于"修复"，而与之相反的思路是“构建”，即从“如果有重复则。。。”换为“如果有不一致则。。。”，不难发现，后者一次迭代就能构建我们所需要的数组，可能开始被题目的"原地"所干扰了，所以脑袋一开始没有“构建”念头，但后来发现，构建过程完全可以在传入的数组上进行。

```
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
```

#### 旋转数组

1. 数组每次右移一格，执行k次，恩，当然知道这个很挫，时间复杂度O(n)。

```
    class Solution {
		public void rotate(int[] nums, int k) {
			int len = nums.length;

			if (k >= len) {
				k = k % len;
			}

			while (k > 0) {
				int temp = nums[len - 1];

				//所有元素往右移位
				for (int i = len - 2; i > -1; i--) {
					nums[i + 1] = nums[i];
				}

				nums[0] = temp;
				k--;
			}
		}
	}
```

2. 利用临时数组，一次性完成k位右移，时间复杂度O(1),但是利用了一个长度为k的数组，最坏情况下空间复杂度为O(n)

```
	class Solution {
		public void rotate(int[] nums, int k) {
			int len = nums.length;
			if (k >= len) {
				k = k % len;
			}

			int[] temp = new int[k];

			
			for (int i = 0; i < k; i++) {
				temp[i] = nums[len - k + i];
			}

			for (int i = len - k - 1; i > -1; i--) {
				nums[i + k] = nums[i];
			}

			for (int i = 0; i < k; i++) {
				nums[i] = temp[i];
			}

		}
	}

```
写完后发现，如果k>len/2,可以将问题变为左移len-k位，这样临时数组空间可以小一点。


3. 看了码友的思路，大呼叫绝，我觉得文字的描述是苍白的，代码已经很直观地表达出思路了

```
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
```


