package id_693;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc 51. N皇后 https://leetcode-cn.com/problems/n-queens/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/28
 */
public class LeetCode_51_693 {

    //回溯法，难点：规则，建议做这个题了解清楚回溯，然后再看这个题的规则，撇捺规则。那样基本就能解开了
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list,new ArrayList<>(),n,0,new boolean[n],new boolean[2 * n],new boolean[2 * n]);
        return list;
    }

    /**
     * @param list
     * @param solution
     * @param n        皇后个数
     * @param row      行
     * @param column   当置皇后的列
     * @param skim     撇，行+列
     * @param restrain 撇 行-列(列-行)的绝对值   ，这里注意，需要注意数据成为负数，所以再 + n，因为行列的差不会超过n
     */
    private void backtrack(List<List<String>> list,List<String> solution,int n,int row,boolean[] column,boolean[] skim,boolean[] restrain) {
        //recursion terminator
        if (solution.size() == n) {
            //process result
            list.add(new ArrayList<>(solution));
            return;
        }
        for (int i = 0; i < n; i++) {
            //process current logic
            int l1 = i + row;
            int l2 = row - i + n;
            if (!column[i] && !skim[l1] && !restrain[l2]) {
                skim[l1] = true;
                restrain[l2] = true;
                column[i] = true;
                char[] str = new char[n];
                Arrays.fill(str,'.');
                str[i] = 'Q';
                solution.add(new String(str));
                //drill down
                backtrack(list,solution,n,row + 1,column,skim,restrain);
                //restore current status
                solution.remove(solution.size() - 1);
                skim[l1] = false;
                restrain[l2] = false;
                column[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        new LeetCode_51_693().solveNQueens(8);

//        int n = 4;
//        boolean[][] used = new boolean[n][n];
//        new LeetCode_51_693().sfa(used,new ArrayList<>(),0,1,n);
//        for (int i = 0; i < used.length; i++) {
//            System.out.println(Arrays.toString(used[i]));
//        }
    }
}
