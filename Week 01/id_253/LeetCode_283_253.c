void moveZeroes(int* nums, int numsSize){
    int nums2[numsSize];
    int j=0;
    for(int i=0;i<numsSize ; i++){
        if(nums[i]!=0){
            nums2[j++]=nums[i];
        }
    }
    for(int i=j;i<numsSize ;i++){
        nums2[i]=0;       
    }
    for(int i=0;i<numsSize;i++){
        nums[i]=nums2[i];
    }
}
