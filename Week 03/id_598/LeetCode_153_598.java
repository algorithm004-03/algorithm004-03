/**
 * @author northleaf
 * @create 2019年10月31日
 */
public class LeetCode_153_598 {
    /**
     * 查找最小值:暴力搜索，从数组中查找最小的值，只需要遍历一次即可
     * @param nums
     * @return
     */
    public int findMin1(int[] nums) {

        //假设最小值为第一个
        int min = nums[0];
        for(int i = 1;i<nums.length;i++){
            min = Math.min(min,nums[i]);
        }
        return min;

    }


    /**
     * 二分查找的方式查找最小值
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {

        //当只有一个元素的时候返回它就可以了
        if(nums.length == 1){
            return nums[0];
        }
        //判断它是不是递增序列
        //只需判断最后一个元素是不是小于第一个元素即可
        //如果最后一个元素大于第一个元素，说明是一个递增序列,这种情况下返回第一个元素就可以了
        if(nums[nums.length -1] > nums[0]){
            return nums[0];
        }
        //如果不是，说明这个序列被处理过，按二分查找的方式，查找变化点
        // 比如原始序列为：1，2，3，4，5，6，7，8
        // 处理后的序列为：3，4，5，6，7，1，2，3
        // 那第处理后的序列中第5个元素（1）即为变化点，因为
        //  它左侧的元素比它大
        //  它右侧的元素也比它小
        int left = 0;
        int right = nums.length - 1;
        //中间元素
        int mid = 0;
        while (left < right){
            mid = left + (right - left) /2 ;
            //如果右侧的元素比它小
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            //如果左侧的元素比它大
            if(nums[mid] < nums[mid -1]){
                return nums[mid];
            }

            if(nums[mid] > nums[0]) {
                left = mid+1;
            }else{
                right = mid -1;
            }

        }
        return nums[mid];

    }
}
