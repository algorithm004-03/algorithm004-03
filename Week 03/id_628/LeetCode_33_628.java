//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找



//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_33_628 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);

            if (nums[mid] < nums[right]) {
                //旋转点在左半边
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        //旋转点索引为left
        int changePoint = left;
        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            //数组中点
            int mid = left + ((right - left) >> 1);
            //相对中点，加偏移量之后取数组模
            int realmid=(mid+changePoint) % nums.length;
            //
            if(nums[realmid]==target)return realmid;
            if(nums[realmid]<target)left=mid+1;
            else right=mid-1;
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
