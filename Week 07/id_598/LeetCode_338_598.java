/**
 * @author northleaf
 * @create 2019年11月26日
 */
public class LeetCode_338_598 {
    public int[] countBits(int num) {
        int[] nums = new int[num+1];

        for(int i = 0;i<num+1;i++){
            nums[i]=getBits(i);
        }

        return nums;
    }

    //获取数字的比特位数
    private int getBits(int i) {

        int count =0;
        while ((i&(-i)) != 0 ){
            if((i&1) != 0 ) {
                count++;
            }
            //右移一位
            i = i>>1;
        }

        return count;
    }

    public static void main(String[] args) {
        LeetCode_338_598 leetCode_338_598 = new LeetCode_338_598();
//        leetCode_338_598.countBits(2);
        System.out.println(leetCode_338_598.getBits(2));
    }
}
