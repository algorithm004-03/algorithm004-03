/**
 * 最大正方形 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 
 * @author L
 *
 */
public class LeetCode_221_138 {
	/**
	 * 动态规划 dp[i][j] == 当前i,j位置由1组成的最大正方形的边长
	 * @param matrix
	 * @return
	 */
	public int maximalSquare(char[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] dp = new int[row + 1][col + 1];

		int maxLen = 0;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (matrix[i - 1][j - 1] == '1') {//当前索引的原始位置左上方位置是正方形
					// 对于原始数组（矩阵）的的每一个元素1，都去比较（左侧 上侧 左上侧）位置的最小正方形边长,
					// 也就是去判断当前位置的左侧/上侧/右上侧是否都是正方形，如果都是则将当前单元格也加入正方形，否则当前单元格不是正方形的一部分
					dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) +1;
					maxLen = Math.max(maxLen, dp[i][j]);
				}
			}
		}
		return maxLen * maxLen;
	}
}
