class Solution {
    public void rotate(int[] nums, int k) {
        int[] newNums = new int[nums.length];
		int right = k%nums.length;
        for (int i = 0; i< nums.length; i++) {
        	if (i + right >= nums.length) {
        		int move = i + right - nums.length;
        		newNums[move] = nums[i];
        		continue;
        	}
        	newNums[i+right] = nums[i];
        }
        nums = newNums;
    }
}