// 方法1
// 1.头移到尾部
// 2.处理剩下的元素的移动
// 3.整个过程执行3次
// 此方法时间复杂度较高，尚需优化

public class RotateArray {
    public void rotate(int[] nums, int k) {
        for(int i =0 ;i < k ; i++){
           nums = moveTailToHead(nums);
        }
    }
    public int[] moveTailToHead(int[] nums){
        int tmp = 0;
        int lastIndex = nums.length - 1;
        int newHead = nums[lastIndex];
        for(int i = lastIndex - 1 ; i > -1; i--){
            nums[i+1] = nums[i];
        }
        nums[0] = newHead;
        return nums;
    }
}