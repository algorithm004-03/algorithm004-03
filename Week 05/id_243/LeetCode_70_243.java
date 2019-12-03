/**
 * @author eazonshaw
 * @date 2019/11/15  15:12
 */
public class LeetCode_70_243 {

    public int climbStairs(int n) {
        //状态数组
        int[] states = new int[n+1];
        //当n为1时特殊处理
        if(n == 1){
            return 1;
        }
        states[0] = 1;
        states[1] = 1;

        for(int i = 2;i<n+1;i++){
            //核心：状态转移方程
            states[i] = states[i-1] + states[i-2];
        }
        return states[n];
    }
}
