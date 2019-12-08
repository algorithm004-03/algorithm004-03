
import java.util.List;

/**
 * 120. 三角形最小路径和
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * <p>[
 * <p>     [2],
 * <p>    [3,4],
 * <p>   [6,5,7],
 * <p>  [4,1,8,3]
 * <p>]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路：递归（傻和记忆化）；dp
 * dp（自底向上）：
 * 找重复性：当前的最小的路径和，肯定是等于上一层并且它能触摸到的（例如，[6,5,7] 中的 6，它能触摸最小值应该是min(4,1) ， 加上它本身
 * problem[i,j] = current[i,j] + sub(dp[i+1,j], dp[i+1,j+1]);
 * dp状态数组：dp[i,j]
 * dp方程（dp状态转移方程）：
 * dp[i,j] = current[i,j] + min(dp[i+1,j], dp[i+1,j+1]);
 *
 * @author jaryoung
 */
public class LeetCode_120_593 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size() - 1;
        int[] dp = new int[triangle.get(row).size() + 1];
        for (int i = row; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    /**
     * 记忆化递归
     *
     * @param triangle 数组
     * @return 最小路径和
     */
    public int minimumTotalByRecursion(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        Integer[][] mono = new Integer[row][col];
        return minimumTotalByRecursion(0, 0, triangle, mono);
    }

    /**
     * 记忆化搜索
     *
     * @param level    层级
     * @param index    当前位置
     * @param triangle 数组
     * @param mono     记忆缓存
     * @return 最小路径
     */
    private int minimumTotalByRecursion(int level, int index, List<List<Integer>> triangle, Integer[][] mono) {
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(index);
        }
        if (mono[level][index] != null) {
            return mono[level][index];
        }
        int left = minimumTotalByRecursion(level + 1, index, triangle, mono);
        int right = minimumTotalByRecursion(level + 1, index + 1, triangle, mono);
        mono[level][index] = Math.min(left, right) + triangle.get(level).get(index);
        return mono[left][index];
    }

}
