//解法1：按列求		执行用时击败约39%
//思路：类似于42. 接雨水, 只要获取到当前柱子左/右边第一个比它矮的柱子,那么就可以确定当前柱子对应的最大矩形
//时间复杂度：O(n^2)
//空间复杂度：O(1)
public int largestRectangleArea(int[] heights) {
	int volume = 0;
	for (int i = 0; i < heights.length; i++) {
		int tempLeft = -1;
		int tempRight = heights.length;
		for (int j = i - 1; j >= 0; j--) {
			if (heights[j] < heights[i]) {
				tempLeft = j;
				break;
			}
		}
		for (int j = i + 1; j < heights.length; j++) {
			if (heights[j] < heights[i]) {
				tempRight = j;
				break;
			}
		}
		volume = Math.max((tempRight - tempLeft - 1) * (heights[i]), volume);
	}
	return volume;
}

//解法2：动态规划		执行用时击败约99%
//思路：和解法1的思路基本一致, 核心在于将每一个柱子的左右边界分别存储至数组, 最后计算的时候逐个取出
//		通过利用指针p进行跳跃寻找比当前柱子小的第一个数, 相比起逐个迭代寻找效率要更高
//时间复杂度：O(n)
//空间复杂度：O(n)
public int largestRectangleArea(int[] height) {
    if (height.length == 0 || height == null) return 0;
	int volume = 0;
	int[] tempLeft = new int[height.length];
	int[] tempRight = new int[height.length];
	tempLeft[0] = -1;
	tempRight[height.length - 1] = height.length;
	for (int i = 1; i < height.length; i++) {
		int p = i - 1;
		while (p >= 0 && height[i] <= height[p]) {
			p = tempLeft[p];
		}
		tempLeft[i] = p;
	}
	for (int i = height.length - 2; i >= 0; i--) {
		int p = i + 1;
		while (p < height.length && height[i] <= height[p]) {
			p = tempRight[p];
		}
		tempRight[i] = p;
	}
	for (int i = 0; i < height.length; i++) {
		int width = tempRight[i] - tempLeft[i] - 1;
		int high = height[i];
		volume = Math.max(volume, width * high);
	}
	return volume;
}

//解法3：栈		执行用时击败82%
//思路：虽然方法五花八门, 但该题的核心部分就是获取当前柱子左/右边第一个比它矮的柱子
//		用栈来做维护一个柱状高度单调递增的栈, 使得入栈的柱子高度都保持当前最大
//		当遍历到一个高度小于栈顶元素的柱子时, 说明找到了当前栈顶元素的右边第一个比它矮的柱子,
//		而左边第一个比它矮的柱子就位于栈顶元素的下面
//		这样获取一个柱子所对应的的核心条件就具备了, 剩下的就是一些边界条件了
//时间复杂度：O(n)
//空间复杂度：O(n)
public int largestRectangleArea2(int[] height) {
	public int largestRectangleArea(int[] height) {
        int volume = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= height.length; i++) {
            int h = (i == height.length ? 0 : height[i]);
            if (stack.isEmpty() || height[stack.peek()] <= h) {
                stack.push(i);
            } else {
                int length = height[stack.pop()];
                int width = stack.isEmpty() ? i : (i - 1 - stack.peek()); 
                volume = Math.max(volume, width * length);
                i--;
            }
        }
        return volume;
    }
}