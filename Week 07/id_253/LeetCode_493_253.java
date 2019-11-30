class Solution {
    public int reversePairs(int[] nums) {
        int cnt = mergeArray(nums,0,nums.length-1);
        return cnt;
    }
    public int mergeArray(int[] nums , int begin , int end){
        if(end <= begin) return 0;
        int mid = begin + (end-begin)/2;
        int cnt = mergeArray(nums , begin , mid) + mergeArray(nums , mid+1 , end);
        for(int i = begin , j = mid+1 ; i <= mid ; i++){
            while(j<=end && nums[i]/2.0 > nums[j]) j++;
            cnt += j - mid - 1;
        }
        Arrays.sort(nums , begin , end+1);
        return cnt;
    }
}
