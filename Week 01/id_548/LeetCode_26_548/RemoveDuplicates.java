public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            int previous = nums[i - 1];
            int current = nums[i];

            if (previous != current) {
                count++;
                nums[count - 1] = current;
            }
        }

        return count;
    }

}



