public class LeetCode_189_383 {

    /**
     * 暴力解法: 每次向右移动1个位置，循环k次
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        for (int j = 0; j < k; j++) {
            int temp = nums[len-1];
            for (int i = len - 2; i > -1; i--) {
                nums[i+1] = nums[i];
            }
            nums[0] = temp;
        }
    }

    /**
     * new一个相同长度的数组，将数据挪动到正确的位置后，再赋值给原来的数组
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        int[] newArray = new int[len];
        for (int i = 0; i < len; i++) {
            newArray[(i+k)%len] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = newArray[i];
        }
    }

    /**
     * 循环替换
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static void rotate3(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        int count = 0;
        for (int i = 0; count < len; i++) {
            int currentIndex = i;
            int currentValue = nums[currentIndex];
            do {
                int nextIndex = (currentIndex + k) % len;
                int temp = nums[nextIndex];
                nums[nextIndex] = currentValue;
                currentIndex = nextIndex;
                currentValue = temp;
                count++;
            } while (currentIndex != i);
        }
    }

}