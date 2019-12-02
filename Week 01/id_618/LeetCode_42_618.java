	class Solution {
		public int trap(int[] height) {
			int area = 0;
			Stack<Integer> stack = new Stack<>();
			int current = 0;

			while (current < height.length) {
				int currentHeight = height[current];

				while (!stack.isEmpty()) {
					int h = height[stack.peek()];

					// 比之前高度小或者相等，跳出循环
					if (currentHeight <= h) {
						break;
					}

					// 比之前的高度大，开始计算面积，
					stack.pop();

					// 已空，没有左边界，跳出循环
					if (stack.isEmpty()) {
						break;
					}

					// 左右两边的位置和高度
					int left = stack.peek();
					int leftHeight = height[left];

					int right = current;
					int rightHeight = currentHeight;

					int bottomHeight = h;

					// 没有高度差，继续出栈，因为栈里的高度是由低到高出栈的，相邻是平的，因此bottomHeight所在的位置不是低洼，不会有积水
					if (leftHeight == bottomHeight) {
						continue;
					}

					int distance = right - left - 1;
					int heightDiff = Math.min(leftHeight, rightHeight) - bottomHeight;

					area += distance * heightDiff;

				}

				// 将当前高度加入栈
				stack.push(current++);

			}

			return area;

		}
	}