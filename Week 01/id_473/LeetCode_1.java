import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * @Author CJ
 * @create 2019/10/20
 */

class LeetCode_1 {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3,2,4}, 6);

        for (int i : ints){
            System.out.println(i);
        }
    }
    //暴力法
   /* public static int[] twoSum(int[] nums, int target) {
        for ( int i = 0; i < nums.length-1; i++ ) {
            for ( int j = i+1; j < nums.length; j++ ) {
                if( nums[i] + nums[j] == target ) {
                    return new int[]{ i, j };
                }
            }
        }
        throw new IllegalArgumentException("在输入的数组中没有符合相加之和为 " + target + " 的两个数。");
    }*/

    //一遍哈希表
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < nums.length; i++ ) {
            int resultNum = target - nums[i];
            if( map.containsKey( resultNum ) ) {
                return new int[] {  map.get( resultNum ), i };
            }
            map.put( nums[i] , i );
        }
        throw new IllegalArgumentException("在输入的数组中没有符合相加之和为 " + target + " 的两个数。");
    }
}