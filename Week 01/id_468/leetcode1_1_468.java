import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @program: leetcode
 * @description: leetcode1
 * @author: 王瑞全
 * @create: 2019-10-1623:24
 **/


public class leetcode1_1_468 {
    private int[] twoSum(int[] nums, int end , int target) {
        Map<Integer,Integer> store=new HashMap();
        int[] result=new int[2];
        for(int i=0;i<=end;i++) {
            if (store.get(target - nums[i]) != null) {
                result[0] = store.get(target - nums[i]);
                result[1] = i;
            }
            store.put(nums[i], i);
        }
        return result;

    }
}
