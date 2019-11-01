public class LeetCode33 {

    public static int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length-1;
        while (begin <= end){
            int mid = (begin + end)/2;
            System.out.println(mid);
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] >= nums[begin] && (nums[mid] < target || target < nums[begin])){
                begin = mid + 1;
            }else if(target > nums[mid] && target < nums[begin]){
                begin = mid + 1;
            }else{
                end = mid -1;
//                end = mid;
            }
        }
        return -1;
    }

    1.如果bgein<=end   end=mid-1
    2.如果begin<end    end=mid

}
