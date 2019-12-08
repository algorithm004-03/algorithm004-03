
/**
 * 26. 删除排序数组中的重复项
 * @Author CJ
 * @create 2019/10/20
 */

public class LeetCode_26 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,3,3,3,4,5,6,7,7,88};
        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int len = removeDuplicates(nums);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    //快慢指针
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if ( nums[i] != nums[j] ){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

}