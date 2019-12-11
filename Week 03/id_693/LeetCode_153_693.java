package id_693;

/**
 * @Desc 153. 寻找旋转排序数组中的最小值  https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/03
 */
public class LeetCode_153_693 {
    //二分法，和老师布置的找有序得无序一样哈，
    public int findMin(int[] nums) {
        //基准值，看mid索引的值小于基准值，大于基准点，说明mid左边是有序的，直接看mid右边，否则反之
        int point = nums[0];
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            //如果i + 1 = j，说明j的下标值就是最小值，
            //但是还需要判断i j的 索引值，如果j值大于i值，说明这里就是无序点，返回j即可
            if (i + 1 == j) {
                if (nums[i] > nums[j]) {
                    return nums[j];
                }
                //j 值不大于i 说明就是一个完全有序数组。反正0即可
                return nums[0];
            }
            if (point > nums[mid]) {
                j = mid;
            } else {
                i = mid;
            }
        }
        return nums[0];
    }

    //不错 ，我自己想复杂了、
    public int findMin2(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < nums[j]) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return nums[i];
    }
}
