// int findMin(int* nums, int numsSize){
//     int left = 0;
//     int right = numsSize -1;
//     while(left<right){
//         int mid=left+(right-left)/2;
//         #[left,mid]ÉıĞò
//         if(nums[right]<nums[mid]){#right<mid
//             left = mid+1;
//         }
//         else{
//             right = mid;
//         }
//     }
    
//     return nums[left];
#ÕÒ×ªÕÛµã
int findMin(int* nums, int numsSize){
    if(numsSize==1)
        return nums[0];
    if(nums[0]<nums[numsSize-1])
        return nums[0];
    for(int i=0; i<numsSize-1; i++){
        if(nums[i]>nums[i+1])
            return nums[i+1];
    }
    return -1;

}