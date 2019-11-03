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

1. 数组每次右移一格，执行k次，恩，当然知道这个很挫，时间复杂度O(n*k)。

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

2. 利用临时数组，一次性完成k位右移，时间复杂度O(n),但是利用了一个长度为k的数组，最坏情况下空间复杂度为O(n)

```
	class Solution {
		public void rotate(int[] nums, int k) {
			int len = nums.length;
			if (k >= len) {
				k = k % len;
			}
			
			if (k == 0) {
				return;
			}

			int[] temp = new int[k];

			//后k个元素放入temp
			for (int i = 0; i < k; i++) {
				temp[i] = nums[len - k + i];
			}

			//前len-k个元素往后移k位
			for (int i = len - k - 1; i > -1; i--) {
				nums[i + k] = nums[i];
			}

			//temp中放入数组头
			for (int i = 0; i < k; i++) {
				nums[i] = temp[i];
			}

		}
	}

```
写完后发现，如果k>len/2,可以将问题变为左移len-k位，这样临时数组空间可以小一点。

3. 如果不希望依赖临时数组，那么思路就要转换为原地+直接到位的排序方式，例如把n需要移到n+k，原先n+k的数字放入temp,然后n=n+k，循环这个步骤，直到所有格子都移动过，其中最大的问题是如何解决n移动k位多次后回到原点后，不能保证所有节点都移动过，所以这个步骤需要执行多次，一开始 0-->k，每次移位计数器+1，当k回到0时，此时再从1开始，即1->k,k回到0结束，直到计数等于数据长度为止，这样就保证所有元素都完成移动，本质上，这个方法是逐一右移的进阶，只不过步长从1变为n，算法的关键是确保所有元素都移动过且只移动一次。后来发现评论区有说，这个轮次是k和n的最大公约数，开始我也想计算出这个轮次，但是发现用count计数更简单，所以就没有往这条路走了。

```
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

				// 将preVal放入目标位置，目标原值存入temp
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

```



4. 看了码友的思路，大呼叫绝，我觉得文字的描述是苍白的，代码已经很直观地表达出思路了。我自己的确没有想到这一层，所以作业还是用上一个方法为准。

```
	class Solution {
		public void rotate(int[] nums, int k) {
			int len = nums.length;
			if (k >= len) {
				k = k % len;
			}
			
			if (k == 0) {
				return;
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

#### 合并两个有序链表
闷想一会后，并没有想到很好的办法，于是拿起纸笔开始用一个例子推导过程，马上就有思路，大体上和题解中的迭代法一致，只是我的写法略微啰嗦了点，但是顺着我的思路，可读性略强一些（个人觉得......），至于递归解法，想了很久，发现本质和迭代是一样的，即拿小的节点的后一个与另一个节点对比，直到没有目标或者自己是结尾。

#### 合并两个有序数组
与链表不同，数组可以随机访问，而且原始已经有序且目标数组就是nums1，通过上述条件不难发现，减少次数的思路就是：用nums2的最大值和nums1的最大值对比，大的移到nums1最后，小的占据nums1的m-1的位置，如果m-1位置的数字是nums2过来的，则与前m-2位对比，必要则移位，重复此过程直到nums2都插入完成。这个思路与题解中的解法3类似，只不过它用了双指针逐个比较，大的落位并指针迁移，也许是思路关系，尽管代码比我更精简，但是表达力不是很直观。


#### 两数之和
忽略暴力解法，思路聚焦于一次迭代得到结果，很容易想到用一个Map存储之前记录，与当前数字之和匹配即返回索引。

#### 移动零
不借助额外容器，就要相伴法在原地移动，还是一样的技巧，拿起笔纸书面推导一个例子，思路很快就出来了，本质就是在一次迭代中，找准“0位置”，将非零的放到这个位置，并更新“0位置”。

#### 加一
这个比较简单，处理好9+1的进位即可。

### 第四课课后练习

#### 设计循环双端队列
用2个stack的解法比较容易，我很快就完成了，但是想尝试一下数组实现。
java源码中，Deque的代表实现是LinkedList和ArrayDeque，前者比较简单，以前我也尝试写过，这次就想试试用数组实现。

既然队列大小是初始固定的，那么就初始化一个足够大的数组就可以了，即2k-1,初始添加的元素在正中间（不管是添加头还是添加尾），后续添加的元素就往其两边放，分别用head和tail指针指向头尾索引即可，这样的结构，添、删、查的时间复杂度都是O(1),缺点就是空间比较浪费。

后来仔细看了ArrayDeque的源码分析，受到启发：k长度的数组也足够了，head和tail指针可以环状移动，这样空间就节省了。

#### 接雨水
撇开暴力法 开始并没有好的思路，后看了题解，理解了动态规划的解法，但是本节主要学习栈，所以还是用栈的思路完成了，看显然这个算法不算好。

