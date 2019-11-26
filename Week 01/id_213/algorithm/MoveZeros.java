class Silution{

//     moveZeros
// 这个问题可以用快排的思想来解决，将0作为中心点。利用一个计数下标，从0开始。
// 遍历数组，数组中所有值与0比较，如果不等于0，就将其放入数组，下标加1。如果
// 等于零，不做处理，继续遍历。遍历完成后，剩余空间用0填充。
    public void moveZeros(int[] nums) {
         int j = 0;
         for(int i = 0; i<nums.length; i++) {
             if(nums[i] !=0) {
                nums[j++] = nums[i];
             } 
         }   
        for(int i = j; i< nums.length; i++){
             nums[i] = 0;
        }
    }
}
