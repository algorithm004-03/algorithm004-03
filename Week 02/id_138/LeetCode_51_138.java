import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * N皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 皇后是直线和斜线攻击的
 *              -----皇后-------
 *                  / | \
 *                 /  |  \
 *                /   |   \
 * 
 * 
 * 
 * @author L
 *
 */
public class LeetCode_51_138 {
	private List<List<String>> res = new ArrayList();
	public List<List<String>> solveNQueens(int n) {
		if (n == 0) {
			return res;
		}

		// 初始化数组
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i;
		}

		Set<Integer> col = new HashSet();// 行/列
		Set<Integer> master = new HashSet();// 主对角线 纵坐标+横坐标固定
		Set<Integer> slave = new HashSet();// 从对角线 纵坐标-横坐标固定
		Stack<Integer> stack = new Stack();

		backHelper(nums, 0, n, col, master, slave, stack);

		return res;
	}

	private void backHelper(int[] nums, int row, int n, 
			Set<Integer> col, 
			Set<Integer> master, 
			Set<Integer> slave,
			Stack<Integer> stack) {
		// TODO Auto-generated method stub
		if (row == n) {// 按行放置queen，遍历完所有行
			List<String> queen = findQueen(stack, n);
			res.add(queen);
			return;
		}
		// 每一行测试是否可以放置queen
		for (int i = 0; i < n; i++) {
			if (!col.contains(i) && !master.contains(row + i) && !slave.contains(row - i)) {
				stack.add(nums[i]);
				col.add(i);
				master.add(row + i);
				slave.add(row - i);
				
				backHelper(nums, row + 1, n, col, master, slave, stack);

				slave.remove(row - i);
				master.remove(row + i);
				col.remove(i);
				stack.pop();
			}
		}

	}
	
	/**
	 *  打印该行皇后位置信息
	 * @param stack
	 * @param n
	 * @return
	 */
	private List<String> findQueen(Stack<Integer> stack, int n) {
		List<String> row = new ArrayList<String>();
		for (Integer num : stack) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				sb.append(".");
			}
			sb.replace(num, num + 1, "Q");
			row.add(sb.toString());
		}
		return row;
	}
	
	public static void main(String[] args) {
        int n = 4;
        LeetCode_51_138 solution = new LeetCode_51_138();
        List<List<String>> res = solution.solveNQueens(n);
        System.out.println(res);
    }

}
