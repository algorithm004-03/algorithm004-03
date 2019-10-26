public class LeetCode_26_333 {

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int index = 0;
        for (int i = 0;i < len - 1;i ++) {
            if (nums[i] == nums[i+1]) {
                for (int j = i+1;j < len - 1;j++) {
                    nums[j] = nums[j+1];
                }
                len--;
                i--;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,2,3,3,3,3,4};
        int len = removeDuplicates(nums);
        System.out.println("Length after deleted : " + len);
        System.out.println("New array :");
        for (int i = 0;i < len;i++) {
            System.out.print("" + nums[i] + " ");
        }
    }
}
