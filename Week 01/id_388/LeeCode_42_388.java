/**
* 接雨水问题
/
class Solution {

    private Stack<Integer> stack = new Stack();

    public int trap(int[] height) {

        if (height.length == 0) {
            return 0;
        }
        int area = 0;
        int current = 0;
        while (current < height.length) {

            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()){
                    break;
                }

                int distance = current - stack.peek() - 1;
                int h = Math.min(height[current],height[stack.peek()]) - height[top];
                area += distance * h;
            }

            stack.push(current++);
        }

        return area;
    }

}