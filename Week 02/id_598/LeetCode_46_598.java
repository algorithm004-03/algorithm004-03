import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 46题
 *
 * @author northleaf
 * @create 2019年10月27日
 */
public class LeetCode_46_598 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> numList = new ArrayList<Integer>();
        for(int i = 0;i<nums.length;i++){
            numList.add(nums[i]);
        }
        permuteNum(0,nums.length,numList,ans);
        return ans;

    }


    private void permuteNum(int from, int n,List<Integer> numList, List<List<Integer>> ans) {
        //终止条件
        if(from ==n ){
            ans.add(new ArrayList<Integer>(numList));
            return;
        }
        //处理当前层逻辑
        for(int i = from;i<numList.size();++i){
            //交换数据
            Collections.swap(numList,from,i);
            //下探
            permuteNum(from+1,n,numList,ans);
            //回溯
            Collections.swap(numList,from,i);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        LeetCode_46_598 leetCode_46_598 = new LeetCode_46_598();
        leetCode_46_598.permute(nums);
    }


//    private void permute(int from, int[] nums, ArrayList<Integer> integers, List<List<Integer>> ans) {
//        //终止条件
//        if(integers.size() == nums.length){
//            ans.add(new ArrayList<Integer>(integers));
//            return;
//        }
//        //处理当前层
//        for(int i = from;i<nums.length;i++){
//            //选当前数
//            integers.add(nums[i]);
//            //下探到下一层
//            permute(i + 1,nums,integers,ans);
//            //回溯
//            integers.remove(Integer.valueOf(nums[i]));
//        }
//
//    }
}
