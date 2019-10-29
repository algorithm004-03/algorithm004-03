import java.util.Arrays;
import java.util.EnumSet;

class RotateArray_189{
    //思路1.移动下标，用循环使得num(i)数移动到num(i+k)即可。要做k与length的判断
    //思路2.全体向右移位，每次移动一格，移动k次
    //思路3.把原有数组按num(i+k)来依次写入新数组；

    public static void rotateArray1(int[] nums,int k) {
        //思路，通过复制新数组，用下标的变化代替数值的变化，达到移动的效果
        //复制数组
        int[] nums2 = nums.clone();
        //如果k大于数组的length，则取余数再移动；
        if (k> nums.length) k = k%nums.length;
        //如果k不大于数组的length，则处理下标；
        if (k <= nums.length) {
            //遍历数组
            for (int i = 0; i < nums.length; i++ ){
                //如果i<k，那么新值是原始数组的末尾来的
                if(i<k){
                    nums[i] = nums2[nums2.length+i-k];
                }
                //如果i>=k,那就直接是从左边移动k个位置过来的
                if(i>=k){
                    nums[i] = nums2[i - k];
                }
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6};
        int k = 100;
        rotateArray1(nums,k);
        System.out.println(Arrays.toString(nums)+ " k=" +k);
        //System.out.println(nums2);

    }

}