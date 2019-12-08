#include <stdio.h>
#include <stdlib.h>

int findSmallInOrder(int *nums, int left, int right) {
    int idx = left;
    int small = nums[left]; 
    for (int i = left + 1; i <= right; i++) {
        if (nums[i] < small) {
            small = nums[i];
            idx = i;
        }
    }
    return idx;
}

int findSmall(int *nums, int numSize) {
    int left = 0;
    int right = numSize - 1;
    int mid = left;
    while (nums[left] >= nums[right]) {
        if (right - left == 1) {
            mid = right;
            break;
        }
        mid = (left + right) / 2;
        if (nums[left] == nums[right] && nums[left] == nums[mid]) {
            mid = findSmallInOrder(nums, left, right);
            break;
        }
        if (nums[mid] >= nums[left])
            left = mid;
        else if (nums[mid] <= nums[right])
            right = mid;            
    }
    return mid;
}

int search(int *nums, int numsSize, int target){
    if (nums == NULL || numsSize == 0) 
        return -1; 
    int idx = findSmall(nums, numsSize);
    int left = 0;
    int right = numsSize - 1;
    int mid;
    if ( idx && target <= nums[idx-1] && target >= nums[0]) 
        right = idx - 1;
    else if (target >= nums[idx] && target <= nums[right])
        left = idx;
    while (left <= right) {
        mid = (left + right) / 2;
        if (target == nums[mid]) return mid;
        else if (target > nums[mid])
            left = mid + 1;
        else 
            right = mid - 1;
    }
    return -1;
}

int main() {
    //int array[] = { 3, 4, 5, 6, 7 ,1, 2 };
    //int array[] = { 1, 0, 1, 1, 1 };
    //int array[] = { 1, 1, 1, 0, 1 };
    //int array[] = { 4, 5, 6, 7, 0, 1, 2 };
    //int array[] = {};
    int array[] = { 1 };
    //int array[] = { 5, 1, 3 };
    //int array[] = { 1, 3 };
    //printf("%d\n", findSmall(array, sizeof(array) / sizeof(array[0])));
    printf("%d\n", search(array, sizeof(array) / sizeof(array[0]), 1));
}