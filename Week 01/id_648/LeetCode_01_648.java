import java.util.HashMap;
import java.util.Map;

public class LeetCode_01_648 {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==(target-nums[i])){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int preNum = target-nums[i];
            if(map.containsKey(preNum)){
                return new int[]{map.get(preNum),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        LeetCode_01_648 leetCode_01_648 = new LeetCode_01_648();
        int[] nums = new int[]{2, 7, 11, 15};
        int[] a =leetCode_01_648.twoSum2(nums,9);
        for(int s :a){
            System.out.print(s);
        }
    }

}
