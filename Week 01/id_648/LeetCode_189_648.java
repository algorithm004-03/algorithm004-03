public class LeetCode_189_648 {
    public void rotate(int[] nums, int k) {
        int tmp;int previous;
        for(int i=0;i<k;i++){
            previous = nums[nums.length-1];
            for(int j=0;j<nums.length;j++){
                tmp = nums[j];
                nums[j]=previous;
                previous=tmp;
            }
        }
    }
    public void rotate2(int[] nums, int k) {
      int[] a = new int[nums.length];
      for(int i=0;i<nums.length;i++){
          a[(i+k)%nums.length]=nums[i];
      }
      for(int i=0;i<nums.length;i++){
          nums[i]=a[i];
      }
    }
    public static void main(String[] args) {
        LeetCode_189_648 leetCode_189_648 = new LeetCode_189_648();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        leetCode_189_648.rotate2(nums,3);
    }
}
