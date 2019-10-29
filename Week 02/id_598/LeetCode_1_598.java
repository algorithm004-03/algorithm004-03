import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode第一题
 *
 * @author northleaf
 * @create 2019年10月22日
 */
public class LeetCode_1_598 {
    public static void main(String[] args) {
        System.out.println("he");
    }

    /**
     * 双重循环法
     *  时间复杂度：O(n²)
     * @param nums
     * @param target
     */
    public int[] twoSum1(int[] nums,int target){
        for(int i = 0;i< nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i] + nums[j] ==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }


    /**
     * 两遍哈希法
     *  时间复杂度O(n)
     *  空间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        //将数据存放在map中，值为key，索引为value
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        //遍历数组并比较
        for(int i = 0;i< nums.length-1;i++){
            if(map.get(target-nums[i]) !=null && map.get(target - nums[i])!=i ){
                return new int[]{i,map.get(target-nums[i])};
            }
        }
        return new int[0];
    }

    /**
     * 一遍哈希法
     *  时间与空间复杂度均为O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        //在遍历的同时插入哈希表并进行比较
        for(int i = 0;i< nums.length;i++){
            if(map.get(target-nums[i]) !=null && map.get(target - nums[i])!=i ){
                //返回的时间注意数组中元素的顺序
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];


    }

}
