//74. 搜索二维矩阵

//解法1：二分查找
//思路：通过观察题目发现矩阵从左到右升序, 且每行的第一位大于前一行的第二位
//		这意味着我们可以把它当做一个有序数组来搜索
//		因为每行最后一个元素为当前行的最大值, 如果target <= 当前行的最大值, 也就意味着target位于该行
//		通过遍历检索到target所在的行
//		对该行数组进行二分查找获取target
//时间复杂度：O(m*logN)：二维矩阵行数为m, 列数为n
//空间复杂度：O(1)
public boolean searchMatrix(int[][] matrix, int target) {
	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
	for (int i = 0; i < matrix.length; i++) {
		if (matrix[i][matrix[i].length - 1] >= target) {
			int left = 0;
			int right = matrix[i].length - 1;
			while (left <= right) {
				int mid = (left + right) >> 1;
				if (matrix[i][mid] == target) return true;
				else if (matrix[i][mid] < target) left = mid + 1;
				else right = mid - 1;
			}
		}
	}
	return false;
}