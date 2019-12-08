int removeDuplicates(int* nums, int numsSize){
    int j=0,i;
    if(numsSize == 0) return 0;
    for(i=0;i<numsSize ; i++){
        if(nums[i]!=nums[j])
        {
            nums[++j]=nums[i];
        }
    }
    return ++j;
}
