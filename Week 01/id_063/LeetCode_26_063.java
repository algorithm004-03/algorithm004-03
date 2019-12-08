/*
思路
从左到右依次迭代，用游标变量curIdx维护当前存放不重复数据的位置，nums[curIdx-1]位置就是上次刚发现的
不重复数据，因为原序列是排序号的序列，所以当前迭代数据如果和nums[curIdx-1]不相同，必然是在前面迭代
中没有出现过的数据，将其存入到新的存放位置，递增curIdx即可

*/

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int curIdx = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[curIdx - 1]) {
                nums[curIdx++] = nums[i];
            }
        }

        return curIdx;
    }
}