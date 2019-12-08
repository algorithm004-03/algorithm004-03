/**
 * 33. 搜索旋转排序数组
 * @Author CJ
 * @create 2019/11/3
 */
class LeetCode_33 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 3;
        System.out.println(search(nums , target));
    }

    //二分查找法
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left+1 < right){
            int mid = (left + right)>>>1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[left]) {
                if (target <= nums[mid] && target >= nums[left]) {
                    right = mid;
                }else {
                    left = mid;
                }
            }else  if (nums[mid] < nums[right]) {
                if (target <= nums[right] && target >= nums[mid]) {
                    left = mid;
                }else {
                    right = mid;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }else if (nums[right] == target) {
            return  right;
        }
        return  -1;
    }


}