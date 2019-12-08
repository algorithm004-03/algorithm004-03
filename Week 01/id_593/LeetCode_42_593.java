import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jaryoung
 * <p>
 * 优秀回答：
 * https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
 */
public class LeetCode_42_593 {

    /**
     * 遍历每一行；
     * 开始计数前，左边必须有墙，height[j] >= i，累计总水滴， 清空temp
     * 计数时，必须当前有坑，就是：height[j] < i
     *
     * @param height 墙的高度
     * @return 总水滴
     */
    public int rowTrap(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int max = getMax(height);
        int sum = 0;
        for (int i = 1; i <= max; i++) {
            int temp = 0;
            boolean start = false;
            for (int j = 0; j < height.length; j++) {
                if (start && height[j] < i) {
                    temp++;
                }
                if (height[j] >= i) {
                    start = true;
                    sum = sum + temp;
                    temp = 0;
                }
            }
        }
        return sum;
    }

    private int getMax(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (max < height[i]) {
                max = height[i];
            }
        }
        return max;
    }


    /**
     * 1. 如果栈不空并且当前指向的高度大于栈顶高度，代表栈内元素和当前的墙可能存在雨水；
     * 2. 如果栈为空，将当前指针入栈，当前指针向后移动
     *
     * @param height
     * @return
     */
    public int stackTrap(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int current = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[stack.peek()] < height[current]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.pop()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }

}