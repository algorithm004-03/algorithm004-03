class Solution {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        
        while (current < height.length) {
            while (!stack.empty() && height[current] >  height[stack.peek()]) {
                int h = height[stack.pop()];
                if (stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[current],height[stack.peek()]);
                sum = sum + distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }
}