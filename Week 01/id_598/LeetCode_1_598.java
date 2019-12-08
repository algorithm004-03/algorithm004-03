import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode第一题
 *
 * @author northleaf
 * @create 2019年10月17日
 */
public class LeetCode_1_598 {

    /**
     * 暴力解法
     *  双重循环暴力求解
     *  时间复杂度：O(n²)
     * @param nums 给定的数组
     * @param target 要计算的目标值
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for(int i = 0 ;i<nums.length - 1;i++){
            for (int j = i+1;j < nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return  new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }


    /**
     * 使用哈希表实现
     *  遍历一次循环即可
     *  时间复杂度为0(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums,int target){
        //构造哈希表
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0 ;i< nums.length ;i++){
            map.put(nums[i],i);
        }
        //再次扫描数组
        for(int i = 0;i<nums.length;i++){
            if(map.get(target - nums[i]) != null){
                return new int[]{i,map.get(target - nums[i])};
            }
        }

        
        return new int[]{};
    }
}
