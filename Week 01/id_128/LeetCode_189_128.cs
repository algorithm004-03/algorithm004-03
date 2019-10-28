public class Solution {
    public void Rotate(int[] nums, int k) {
        //bounds checking
        if (nums.Length < 2)
            return;
            
        k = k % nums.Length;
        
        Reverse(nums, 0, nums.Length);
        Reverse(nums, 0, k);
        Reverse(nums, k, nums.Length - k);
        
    }
    
    private void Reverse(int[] nums, int start, int length) {
        int end = start + length - 1;
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
    
   
 
}