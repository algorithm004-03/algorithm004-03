class Solution {
  public int trap_brute_force(int[] height) {
    if (0 == height.length) return 0;
    int ans = 0;
    int[] left_max = new int[height.length];
    int[] right_max = new int[height.length];
    for (int i = 0; i < height.length; i++){
      int max_left = 0, max_right = 0;
      for (int j = i; j >= 0; j--) max_left = Math.max(max_left, height[j]);
      for (int j = i; j < height.length; j++) max_right = Math.max(max_right, height[j]);
      ans += Math.min(max_left, max_right) - height[i];
    }
    return ans;
  }
  
  public int trap_dp(int[] height) {
    if (0 == height.length) return 0;
    int ans = 0;
    int[] left_max = new int[height.length];
    int[] right_max = new int[height.length];
    
    left_max[0] = height[0];
    right_max[height.length - 1] = height[height.length - 1];
    
    for (int i = 1; i < height.length; i++) left_max[i] = Math.max(height[i], left_max[i - 1]);
    for (int i = height.length - 2; i >= 0; i--) right_max[i] = Math.max(height[i],right_max[i + 1]);
    
    for (int i = 0; i < height.length; i++) ans += Math.min(left_max[i], right_max[i]) - height[i];
    
    return ans;
  }
  
  public int trap_stack(int[] height) {
    if (0 == height.length) return 0;
    int ans = 0, current = 0;
    
    Stack<Integer> st = new Stack<>();
    while (current < height.length) {
      while (!st.empty() && height[st.peek()] < height[current]) {
        int top = st.pop();
        if (st.empty()) break;
        ans += (current - st.peek() - 1) * (Math.min(height[current], height[st.peek()]) - height[top]);
      }
      st.push(current++);
    }
    return ans;
  }
  
  public int trap_double_pointer(int[] height) {
    if (0 == height.length) retrun 0;
    
    int ans = 0;
    int max_left = 0;
    int max_right = 0;
    int left = 0;
    int right = height.length - 2;
    
    for (int i = 1; i < height.length - 1 ; i++) {
      if (height[left-1] < height[right+1]) {
        max_left = Math.max(height[left-1], max_left);
        if (max_left > height[left])
          ans += max_left - height[left];
        left++;
      } else {
        max_right = Math.max(height[right+1], max_right);
        if (max_right > height[right])
          ans += max_right - height[right];
        right++;
      }
    }
    return ans;
  }
}