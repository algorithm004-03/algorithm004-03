/**
 * @Date 2019/12/8
 **/
public class LeetCode_300_648 {
    public int lengthOfLIS(int[] nums) {

        return maxLengthOfLIS(nums,Integer.MIN_VALUE,0);
    }
    public int maxLengthOfLIS(int[] nums,int pre,int cur){
        if(cur == nums.length){
            return 0;
        }
        int taken=0;
        if(nums[cur]>pre){
            taken = 1+maxLengthOfLIS(nums,nums[cur],cur+1);
        }
        int notaken = maxLengthOfLIS(nums,pre,cur+1);
        return Math.max(taken,notaken);
    }
    public int lengthOfLIS2(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        for(int i=1;i<dp.length;i++){
            int maxnum = 0 ;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    maxnum = Math.max(maxnum,dp[j]);
                }
            }
            dp[i] = maxnum+1;
        }

        return 0;
    }
    public static void main(String[] args) {
        LeetCode_300_648 leetCode_300_648 = new LeetCode_300_648();
        int[] arr = new int[]{10,9,2,5,3,7,101,18};
        int num = leetCode_300_648.lengthOfLIS(arr);
        System.out.println(num);
    }
}
