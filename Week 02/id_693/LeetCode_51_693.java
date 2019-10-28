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
    List<List<String>> list = new ArrayList<>();
    boolean used[][];

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), n, 0, n);

        return list;
    }

    private void backtrack(List<List<String>> list, List<String> solution, int n, int row, int column) {
        //递归终止符
        if (row == column) {
            list.add(new ArrayList<>(solution));
        }

        for (int i = row; i < n; i++) {
            //判断是否符合条件row
            //if 符合条件，添加元素，进入下一层
            backtrack(list, solution, n, row +1, column);
            //清理下一层的数据


        }
    }


    public void sfa(boolean[][] used, List<String> temp, int i, int j, int n) {
        //i-- j--
        int ti = i;
        int tj = j;
        while (ti >= 0 && tj >= 0 && ti < n && tj < n) {
            used[ti--][tj--] = true;
        }
        //i ++ j++
        ti = i;
        tj = j;
        while (ti >= 0 && tj >= 0 && ti < n && tj < n) {
            used[ti++][tj++] = true;
        }
        // i++ j--
        ti = i;
        tj = j;
        while (ti >= 0 && tj >= 0 && ti < n && tj < n) {
            used[ti++][tj--] = true;
        }
        //i-- j++
        ti = i;
        tj = j;
        while (ti >= 0 && tj >= 0 && ti < n && tj < n) {
            used[ti--][tj++] = true;
        }

        //i= 0
        ti = 0;
        tj = j;
        while (ti >= 0 && tj >= 0 && ti < n && tj < n) {
            used[ti++][tj] = true;
        }
        //j= 0
        ti = i;
        tj = 0;
        while (ti >= 0 && tj >= 0 && ti < n && tj < n) {
            used[ti][tj++] = true;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        boolean[][] used = new boolean[n][n];
        new LeetCode_51_693().sfa(used, new ArrayList<>(), 0, 1, n);
        for (int i = 0; i < used.length; i++) {
            System.out.println(Arrays.toString(used[i]));
        }
    }
}
