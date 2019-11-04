int search(int* nums, int numsSize, int target){
    if(numsSize==0)
        return -1;
    int left = 0;
    int right = numsSize -1;
    while(left<=right){
        int mid = left+(right-left)/2;
        printf("%d,%d,\n",left,mid);
        if(nums[mid]==target)
            return mid;
        if(nums[left]==target)
            return left;
        if(nums[right]==target)
            return right;
        #[left,mid]有序
        if(nums[left]<nums[mid]){
            if(nums[left]>target||nums[mid]<target)
                left=mid+1;
            else
                right=mid-1;
        }
        #[left,mid]无序，则[mid,right]有序
        else{
            if(nums[right]<target||nums[mid]>target)
                right=mid-1;
            else
                left=mid+1;
        }
    }

    return -1;

}