/**
 * Created by leesen on 2019/10/31.
 */
public class LeetCode_81_338 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            //相比于不重复的数据,只需要对比两端与mid的值,去重后收缩即可
            if (left != mid && nums[left] == nums[mid]) {
                left++;
                continue;
            }
            if (nums[right] == nums[mid]) {
                right--;
                continue;
            }

            //左边单调,比最大的还大,继续往右找
            //****nums[left] <= nums[mid], 此处必须有=号
            // 否则当left和mid值相等又都不等于target的时候right = mid - 1可能正好跳过了值
            if (nums[left] <= nums[mid] && (target > nums[mid] || target < nums[left])) left = mid + 1;

            else if (target < nums[left] && target > nums[mid]) left = mid + 1; //左边非单调, 但是比左边小,比mid大,继续往右找
            else right = mid;
        }
        return nums[left] == target ? true : false;
    }

    public static void main(String[] args) {
        LeetCode_81_338 rotatedSortedArrayPro_81 = new LeetCode_81_338();
        int[] a = {2,5,6,0,0,1,2};
        System.out.println(rotatedSortedArrayPro_81.search(a, 3));
    }
}
