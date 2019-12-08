class Solution {

    /**
     * 使用辅助指针j，从0位置开始，遍历整个数组，将非0元素前移，将0后移
     * @param nums
     */
    public void moveZeroes(int[] nums) {

        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            // 如果当前元素不为0，则将其放在数组前部，即j的位置。
            if (nums[i] != 0) {
                nums[j] = nums[i];
                // 如果i, j不相等，则说明有0存在，将0后移
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }

    }
    /**
     * 两次循环，第一次循环将非0的元素逐个赋值到数组前面部分，第二次循环将剩余位置全部赋值为0
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int zeroNum = 0;
        int index = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroNum++;
            } else {
                nums[index++] = num;
            }
        }

        for (int i = 0; i < zeroNum; i++) {
            nums[nums.length - zeroNum + i] = 0;
        }
    }

}