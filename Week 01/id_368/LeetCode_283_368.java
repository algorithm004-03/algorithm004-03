import java.util.Arrays;

public class LeetCode_283_368 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 1, 0 ,0 ,100};
        Arrays.stream(moveZeros(nums)).forEach(i -> {
            System.out.println(i);
        });
    }

    public static int[] moveZeros (int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums;
        }
        // 设置下一个非零元素的下标
        int j = 0;
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 非零元素移动到的下标位置
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
        return nums;
    }
}
