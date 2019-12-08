package lesson3;

public class LeetCode_26_633 {

    public int removeDuplicates(int[] nums) {
        int i = 0; // 不变指针指向的元素
        // 有序， j = i + 1
        for (int j = 1; j < nums.length; j++) {
            // 与i指针指向的元素不同 则更新i后面的元素
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
            // 与nums[i]重复， i指针不动，跳过，继续遍历下一个元素
        }
        // for 循环结束后 i指针指向了数组的最后一个元素
        return i + 1;
    }

}
