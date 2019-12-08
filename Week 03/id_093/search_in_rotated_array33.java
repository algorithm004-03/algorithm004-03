class search_in_rotated_array33{

    public static int search_in_rotated_array33(int[] nums, int target){
        //第一步，处理空集或者null的特殊情况
        if (nums == null || nums.length ==0){
            return -1;
        }
        //定义首末指针
        int left = 0;
        int right = nums.length - 1;
        //当首末指针不相交时，
        while (left <= right){
            //中位数为首末指针的中间，如果中位数等于目标值，直接就输出结果的下标/指针mid；
            int mid = (right + left) / 2;
            if (nums[mid] == target) return mid;
            //如果首指针的值不大于中位数的值（该区间内无旋转）
            if (nums[left] <= nums[mid]) {
                //如果target值在左侧区间
                if(target >= nums[left] && target < nums[mid])
                    //那么把末指针移到中间指针的左方一格
                    right = mid - 1;
                    //如果target值在右侧区间，那把左侧指针移到中间指针右侧一格
                else left = mid + 1;
            }
            else {
                //如果target在中右侧区间
                if (target <= nums[right] && target > nums[mid])
                    //把首指针移到中间指针右侧
                    left = mid + 1;
                    //如果target在左侧区间，把末指针移动到中间偏左一格
                else right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums1 = {5,6,9,1,2,3};
        int target1 = 8;
        System.out.println(search_in_rotated_array33(nums1,target1));
    }

}
