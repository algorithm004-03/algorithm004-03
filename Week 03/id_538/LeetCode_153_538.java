class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0){
            return -1;
        }
        int low = 0;
        int height = nums.length - 1;
        int middle = 0;
        int min = nums[0];
        //效率很低啊,不过时间太晚了.明天要上班了  先这样吧
        while (low <= height){
            middle = low + (height - low) / 2;
            min = Math.min(min,nums[middle]);
            if (nums[middle] >= nums[low] && nums[height] < nums[low]){
                min = Math.min(min,nums[height]);
                low = middle + 1;
            }else {
                min = Math.min(min,nums[low]);
                height = middle - 1;
            }
        }
        return min;
    }
}
