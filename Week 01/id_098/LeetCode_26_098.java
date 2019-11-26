//暴力法（双循环）
class Solution1 {
    public int removeDuplicates(int[] nums) {
        int newLength = nums.length;
        int skip = 1;
        for (int i=0; i<nums.length; i++) {
            for (int j=i+skip; j<nums.length; j++) {
                if (nums[i] == nums[j]) {
                    newLength--;
                    skip++;
                } else {
                    nums[i+1] = nums[j];
                    break;
                }
            }
        }
        return newLength;
    }
}

//优化（双指针）
class Solution2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        //标志指针
        int j = 0;
        for (int i=0; i<nums.length; i++) {
            if(nums[j] != nums[i]) {
                nums[j+1] = nums[i];
                j++;
            }

        }
        return j+1;
    }
}

//最优解 （单指针） 利用有序数组以及int可直接比较大小特性（覃超老师指导）
class Solution3 {
    public int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums)
            if (n > nums[i-1])
                nums[i++] = n;
        return i;

    }
}

