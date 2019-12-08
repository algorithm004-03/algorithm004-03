import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 77题
 *
 * @author northleaf
 * @create 2019年10月23日
 */
public class LeetCode_77_598 {


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        combine(1,n,k,new ArrayList<Integer>(),lists);

        return lists;
    }

    private void combine(int first, int n, int k, ArrayList<Integer> integers, List<List<Integer>> lists) {
        //如果集合中的元素与要选择元素的个数相同，则可以终止
        if(integers.size() == k ){
            lists.add(new ArrayList<Integer>(integers));
            return;
        }
        //处理当前层数据
        for(int i = first ;i<n + 1;++i){
            //选当前数
            integers.add(i);
            combine(i+1,n,k,integers,lists);
            //不选当前数，此处就是一个回溯
            integers.remove(Integer.valueOf(i));
        }

    }

}

