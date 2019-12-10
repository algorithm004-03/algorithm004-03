//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    	//
		int[] result = new int[triangle.size()+1];

		for (int i = triangle.size()-1;i >= 0;i--){
			for (int j = 0;j <triangle.get(i).size(); j++){
				result[j] = Math.min(result[j], result[j+1]) + triangle.get(i).get(j);
			}
		}
		return result[0];
    	//代码是错误的，不能直接这么写，二维数组和一维数组不一样
		/*Integer[][] result = triangle.toArray(new Integer[0][0]);
        for (int row = result.length - 2;row >= 0; row--) {
            //f[i,j] += Math.min(f[i+1,j],f[i+1,j+1]);
			//result[i][j] += Math.min(result[i+1][j],result[i+1][j+1]);
			for (int column = 0;column < result[row].length;column++){
				result[row][column] += Math.min(result[row + 1][column],result[row + 1][column + 1]);
			}
        }
        return result[0][0];*/
		//代码已测过没问题，但是耗时太久，花在对二维数组做初始化了，java暂时好像没有更好的办法，舍弃
		/*Integer[][] result = new Integer[triangle.size()][];
		for (int row = 0;row < result.length;row++){
			result[row] = new Integer[triangle.get(row).size()];
			for (int column = 0;column <result[row].length;column++){
				result[row][column] = triangle.get(row).get(column);
			}
		}
		System.out.println(Arrays.deepToString(result));
		for (int row = result.length - 2;row >= 0; row--) {
			//f[i,j] += Math.min(f[i+1,j],f[i+1,j+1]);
			//result[i][j] += Math.min(result[i+1][j],result[i+1][j+1]);
			for (int column = 0;column < result[row].length;column++){
				result[row][column] += Math.min(result[row + 1][column],result[row + 1][column + 1]);
			}
		}
		return result[0][0];*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
