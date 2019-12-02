package id_713.example;

import java.util.List;

/**
 * 120. 三角形最小路径和
 */
public class LeetCode_120_Triangle {

    /*
    给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

    例如，给定三角形：

    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]

    自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/triangle
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int minimumTotal(List<List<Integer>> triangle) {

        int row = triangle.size();
        int[] dp = new int[row + 1];

        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }

}
