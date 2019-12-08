package test1.week_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2019/10/27.
 */
public class Leetcode_77_638 {


    /**
     * 1------n,k个数组合
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Stack<Integer> eleIntegers = new Stack<Integer>();
        helperCombine(1,k,n,res,eleIntegers);
        return res;
    }

    private static void helperCombine(int first,int k,int n,List<List<Integer>> res,Stack<Integer>  eleIntegers) {
        if(eleIntegers.size() == k){
            res.add(new ArrayList<Integer>(eleIntegers));
            return;
        }

        //process
        for(int i=1;i < n+1;i++){
            if (eleIntegers.contains(i)){
                continue;
            }
            if(!eleIntegers.isEmpty() && eleIntegers.peek() > i){
                continue;
            }
            eleIntegers.add(i);
            helperCombine(first + 1,k,n,res,eleIntegers);
            //回溯
            eleIntegers.pop();
        }
        //reverse status

    }
}
