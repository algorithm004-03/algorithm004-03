/**
 * 搜索旋转排序数组
 * @author L
 *
 */
public class LeetCode_33_138 {
	public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left<right) {
        	int mid = (left+right+1)>>>1;
        	if(nums[mid] == target) {
        		return mid;
        	}
        	if(nums[mid] <= nums[right-1]) {//可能在mid左边也可能在右边需要继续判断
        		//右边是有序的
        		if(nums[mid]<target && target<=nums[right-1]) {
        			left = mid+1;
        		}else {
        			right = mid;
        		}
        	}else {
        		//左边是有序的
        		if(nums[left] <= target && target < nums[mid]) {
        			right = mid;
        		}else {
        			left = mid+1;
        		}
        			
        	}
        }
        return -1;
    }
}
