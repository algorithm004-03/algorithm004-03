import java.util.ArrayList;
import java.util.List;

/**
 * @author eazonshaw
 * @date 2019/11/15  15:35
 *
 * 题目：三角形最小路径和
 *
 */
public class LeetCode_120_243 {

    //动态规划，利用状态转移表，建立二维数组（自顶向下）
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n == 0){
            return 0;
        }
        //状态转移表
        int[][] states = new int[n][n];
        //记录初始坐标
        states[0][0] = triangle.get(0).get(0);
        //动态规划
        for(int i = 1;i < n;i++){
            List<Integer> list = triangle.get(i);
            for(int j = 0;j < list.size();j++){
                if(j == 0){
                    states[i][0] = states[i-1][0] + list.get(j);
                }
                else if(j == list.size()-1){
                    states[0][j] = states[0][j-1] + list.get(j);
                }
                else{
                    states[i-j][j] = Math.min(states[i-j-1][j],states[i-j][j-1]) + list.get(j);
                }
            }
        }
        //比较计算最小路径值
        int rs = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++){
            rs = Math.min(states[n-1-i][i],rs);
        }
        return rs;
    }

    //动态规划，自底向上，利用一位数组
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n == 0){
            return 0;
        }
        int[] states = new int[n+1];
        for(int i = n-1;i >= 0;i--){
            for(int j = 0;j <= i;j++) {
                states[j] = Math.min(states[j],states[j+1]) + triangle.get(i).get(j);
            }
        }
        return states[0];
    }


}
