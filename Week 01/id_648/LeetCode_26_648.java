import java.util.ArrayList;
import java.util.List;

public class LeetCode_26_648 {
    public int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i==0){
                list.add(nums[i]);
            }else {
                if(!list.contains(nums[i])){
                    list.add(nums[i]);
                }
            }
        }
        for(int i=0;i<list.size();i++){
            nums[i]=list.get(i);
        }
        return list.size();
    }
    public int removeDuplicates2(int[] nums) {

        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        LeetCode_26_648 leetCode_26_648 = new LeetCode_26_648();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int length =leetCode_26_648.removeDuplicates2(nums);
        System.out.println(length);
    }
}
