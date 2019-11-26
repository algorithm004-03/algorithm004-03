/**
 * 搜索旋转数组的数字
 */
public class LeetCode_33_648 {
    int target;
    int[] nums;

    public int find_rotate_index(int[] nums){
        int left =0;
        int right = nums.length-1;
        if(nums[left]< nums[right]){
            return 0;
        }
        while (left<=right){
            int pivot = (left+right)/2;
            if(nums[pivot]>nums[pivot+1]){
                return pivot+1;
            }
            if(nums[pivot]>nums[left]){
                left=pivot+1;
            }else {
                right=pivot-1;
            }
        }
        return 0;
    }

    public int search(int left,int right){
        while(left<=right){
            int pivot = (left+right)/2;
            if(nums[pivot]==target){
                return pivot;
            }else {
                if(nums[pivot]<target){
                    left=pivot+1;
                }else {
                    right=pivot-1;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        this.target=target;
        this.nums=nums;
        if(nums.length==0){return -1;}
        if(nums.length==1){
            return nums[0]==target?0:-1;
        }
        int rotate_index = find_rotate_index(nums);
        if(nums[rotate_index]==target){
            return rotate_index;
        }
        if(rotate_index==0){
           return search(0,nums.length-1);
        }else if(nums[rotate_index]>target){
            return search(0,rotate_index);
        }else {
            return search(rotate_index,nums.length-1);
        }
    }
    public static void main(String[] args) {
        LeetCode_33_648 leetCode_33_648 = new LeetCode_33_648();
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int index = leetCode_33_648.search(nums,0);
        System.out.println(index);
    }
}
