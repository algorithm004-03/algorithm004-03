import java.util.HashMap;
import java.util.Map;

/**
 * @author eazonshaw
 * @date 2019/10/23  16:02
 *
 * 题目：1. 两数之和
 *
 * 描述：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例：给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 链接：https://leetcode-cn.com/problems/two-sum/
 */
public class LeetCode_1_243 {

    /**
     * 暴力法：冒泡遍历，两数和符合要求则返回
     */
    public int[] twoSum1(int[] nums, int target) {

        for(int i=0;i<nums.length;++i){
            int num1 = nums[i];
            for(int j=i;j<nums.length;++j){
                int num2 = nums[j];
                if(num1+num2 == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 利用hash表，遍历两次，第一遍在hash表存储，num值作为key，index下标作为value值；第二遍将差值target-num看下有没有对应的key且不是原来的value，有则取出value值。
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;++i){
            map.put(nums[i],i);
        }
        for (int i=0;i<nums.length;++i) {
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff)!=i) {
                return new int[]{i, map.get(diff)};
            }
        }
        return new int[]{};
    }

}
