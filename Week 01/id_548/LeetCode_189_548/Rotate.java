public class Rotate {


    public void rotate(int[] nums, int k) {
        if(k > nums.length){
            k = k - nums.length;
        }

        if(k >= nums.length/2){
            int[] nums2 = new int[nums.length - k];
            int j = 0;
            for(int i = 0; i < nums.length - k;i++){
                nums2[i] = nums[i];
            }
            for(int i = nums.length - k ;i < nums.length;i++){
                nums[j] =  nums[i];
                j++;
            }
            j = 0;
            for(int i = k; i < nums.length;i++){
                nums[i] = nums2[j];
                j++;
            }
        }
        if(k < nums.length/2){
            int[] nums2 = new int[k];
            int j = 0;
            for(int i = nums.length - k; i < nums.length;i++){
                nums2[j] = nums[i];
                j++;
            }
            j = nums.length - 1;
            for(int i = nums.length - k - 1 ; i >=0;i--){
                nums[j] = nums[i];
                j--;
            }
            for(int i = 0;i < nums2.length;i++){
                nums[i] = nums2[i];
            }
        }
    }

}
