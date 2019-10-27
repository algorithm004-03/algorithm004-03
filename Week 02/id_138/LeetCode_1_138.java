import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 1.审题，确认搞懂题意
 * 2.整理思路，分析算法时间、空间复杂度，找出最优解
 * 3.code完成编码实现
 * 4.test完成测试用例
 * @author Lukas
 * @since 2019/10/21 22:28
 **/
public class LeetCode_1_138 {

    /**
     * 暴力法求解，从左到右遍历数组，对于任意一个元素，判断该元素右侧是否存在满足条件的其他元素
     * 时间复杂度:O(n^2)
     * 空间复杂度:0(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSums_solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {//外层循环最右侧为length-2
            for (int j = i+1; j < nums.length; j++) {//内层循环从i+1开始到length-1
                if (nums[i] + nums[j] == target) {//找到了
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * 使用map优化
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSums_solution2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {//初始化map
            map.put(nums[i], i);//元素为key，下标为value
        }
        int key = 0;
        for (int i = 0; i < nums.length; i++) {
            key = target-nums[i];
            if (map.containsKey(key) //代表找到了
                    && i!=map.get(key)){//代表找到的不是自己
                return new int[]{i, map.get(key)};
            }
        }
        return null;
    }


}
