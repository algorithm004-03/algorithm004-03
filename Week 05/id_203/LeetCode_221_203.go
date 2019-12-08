package week05

/**
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximal-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

func maximalSquare(matrix [][]byte) int {
	var maxSide byte
	for i := range matrix{
		for j := range matrix[i]{
			if i != 0 && j != 0 {
				if matrix[i][j] == '1'{
					matrix[i][j] = 1 + min(matrix[i-1][j], matrix[i][j-1], matrix[i-1][j-1])
				}
			}

			if matrix[i][j] - '0' > maxSide{
				maxSide = matrix[i][j] - '0'
			}
		}
	}

	return int(maxSide) * int(maxSide)
}

func min(a ...byte) byte {
	min := a[0]
	for i := 0; i < len(a); i++ {
		if a[i] < min {
			min = a[i]
		}
	}
	return min
}