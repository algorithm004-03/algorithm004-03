class Solution {
    

    /**
     * 通过3次翻转进行rotate
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return ;
        k %= nums.length;
        reverseArray(nums, 0, nums.length - 1 -k);
        reverseArray(nums, nums.length - k, nums.length - 1);
        reverseArray(nums, 0, nums.length - 1);
    }
    private void reverseArray(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
    
    
    
    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return ;
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            newNums[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; ++i) {
            nums[i] = newNums[i];
        }
    }

    /**
     * 暴力法
     */
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return ;
        for (int i = 0; i < k; i++) {
            moveLastToFirst(nums);
        }
    }
    private void moveLastToFirst(int[] nums) {
        int target = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; --i) {
            nums[i] = nums[i - 1];
        }
        nums[0] = target;
    }
}