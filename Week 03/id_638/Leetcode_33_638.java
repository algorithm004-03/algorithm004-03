package test1.week3;

public class LeetCode_33_638 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[right] == target) return right;
            if(nums[left] == target) return left;
            if(nums[mid] < nums[right]){
                if(target > nums[mid] && target < nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }else{
                if(target < nums[mid] && target > nums[left]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return -1;
    }

//    public int check(int i){
//
//    }
//public static void main(String[] args) {
//    int[] arr = {4, 5, 0,0, 1, 2, 2};
//
//
//    int temp = binarySearch(arr,0,arr.length,arr[arr.length-1],-1);
//    if (temp == -1){
//
//    }
//    System.out.println("temp:"+temp);
//
//    System.out.println();
//}
//
//
//    public static int binarySearch(int a[],int low,int arrLen,int target,int res) {
//        int mod = arrLen % 2;
//        System.out.println("mod:"+mod);
//        int s = arrLen / 2;
//        System.out.println("s:"+s);
//        int newArrLen = mod == 0 ? s -1:s;
//        System.out.println("index:"+newArrLen+"arr[index]:"+a[newArrLen]);
//        if (res == -1){
//
//        }
//        int high = newArrLen;
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            if (a[mid] > target)
//                high = mid - 1;
//            else if (a[mid] < target)
//                low = mid + 1;
//            else
//                return mid;
//        }
//        //
//        return -1;
//    }
}
