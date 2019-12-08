import java.util.*;

/**
 * @program: leetcode
 * @description: 3sum
 * @author: 王瑞全
 * @create: 2019-10-2014:40
 **/


public class leetcode15_1_468 {
    //1.排序
    //2。利用双指针法(使用过的
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length==0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>>  result=new HashSet<>();
        for(int i=0;i+2<nums.length;i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
