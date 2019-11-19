//动态规划，dp[i],以i为结尾的最大子序和
//递推公式为：
// if(dp[i-1]>0) 
//     dp[i]=nums[i]+dp[i+1];
// else 
//     dp[i]=nums[i]
int maxSubArray(int* nums, int numsSize){
    int max = nums[0];
    int* dp = (int*)malloc(sizeof(int)*numsSize);
    dp[0] = nums[0];
    for(int i=1; i<numsSize; i++){
        if(dp[i-1]>=0){
            dp[i]=nums[i]+dp[i-1];
        }
        else
            dp[i]=nums[i];
        if(max<dp[i])
            max = dp[i];
    }
    return max;

}