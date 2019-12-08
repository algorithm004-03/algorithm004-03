package id_693.practise;

import java.util.*;

/**
 * @Desc 15. 三数之和  https://leetcode-cn.com/problems/3sum/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/16
 */

public class LeetCode_15_693 {
    /*
    1、对元素排序。(这是关键)
    2、k值 > 0 直接排除，并且加1 且去重复元素
    3、k > 0 且与之前元素相等，属于重复元素，去除
    4、s (i值+j值+k值)
       4.1 s > 0 那么说明结果太大了。那么久把j下标上移，也就是j，同时也考虑去重
       4.2 s < 0 那么说明结果太小了。那么久把i下标下移，也就是i，同时也考虑去重
       4.3 s = 0 那么就是结果了，直接i下标下移，j下标上移，同时ij都需要考虑去重
 */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int k;
        int i;
        int j;
        int complement;
        List<List<Integer>> result = new ArrayList<>();
        for (k = 0; k < len - 2; k++) {
            if (nums[k] > 0) break;
            if (k == 0 || nums[k] != nums[k - 1]) {
                i = k + 1;
                j = len - 1;
                while (i < j) {
                    complement = nums[k] + nums[i] + nums[j];
                    if (complement == 0) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                        while (i < j && nums[i] == nums[i + 1]) i++;
                        while (i < j && nums[j] == nums[j - 1]) j--;
                        i++;
                        j--;
                    } else if (complement < 0) i++;
                    else j--;
                }
            }
        }
        return result;
    }

    //参考国际站，但是这个原来的 多了一个k>0的判断，可以不用，因为k肯定大于0 (真正严格的代码是不允许这样写的)
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < (nums.length - 2); k++) {
            if (nums[k] > 0) break;
            if (k == 0 || nums[k] != nums[k - 1]) {
                int i = k + 1, j = nums.length - 1, sum = 0 - nums[k];
                while (i < j) {
                    if (nums[i] + nums[j] == sum) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                        while (i < j && nums[i] == nums[i + 1]) i++;
                        while (i < j && nums[j] == nums[j - 1]) j--;
                        i++;
                        j--;
                    } else if (nums[i] + nums[j] < sum) i++;
                    else j--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_15_693().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
