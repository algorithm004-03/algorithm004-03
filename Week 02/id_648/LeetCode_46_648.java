import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class LeetCode_46_648 {
    List<List<Integer>> list= new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
            ArrayList<Integer> nums_lst = new ArrayList<>();
            for(int num:nums){
                nums_lst.add(num);
            }
            List<List<Integer>> output = new LinkedList<>();
            backtrack(nums.length,nums_lst,output,0);
            return output;
        }
        private void backtrack(int n,ArrayList<Integer> nums, List<List<Integer>> output,int first){
            if(first==n){
                //如果层数等于nums长度结束递归
                output.add(new ArrayList<Integer>(nums));
            }
            for(int i=first;i<n;i++){
                //交换当前层两个数的位置
                Collections.swap(nums,first,i);
                //进入下一层递归
                backtrack(n,nums,output,first+1);
                //保证进入每一层递归的时候nums 中的数字位置是不变的
                Collections.swap(nums,first,i);
            }
    }
    public static void main(String[] args) {
        LeetCode_46_648 leetCode_46_648 = new LeetCode_46_648();
        int[] nums = new int[]{1,2};
        leetCode_46_648.permute(nums);


    }
}
