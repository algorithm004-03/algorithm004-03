class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int height = nums.length - 1;

        while(low <= height){
            int middle = (low + height) / 2;
            if (nums[middle] == target){
                return middle;
            }
            //左半有序
            if(nums[low] <= nums[middle]){
                if(target >= nums[low] && target < nums[middle]){
                    height = middle - 1;
                }else{
                    low = middle + 1;
                }
            }else {//右半有序
                if (target > nums[middle] && target <= nums[height]){
                    low = middle + 1;
                }else {
                    height = middle - 1;
                }
            }
        }
        return -1;
    }
}
