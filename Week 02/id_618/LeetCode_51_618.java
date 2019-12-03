class Solution {
	// 存放最终的结果
	private List<List<String>> results = new ArrayList<>();

	// 处于被攻击位置的列索引
	private int[] cols;
	// 处于被攻击的左对角线
	private int[] leftDiagonals;
	// 处于被攻击的右对角线
	private int[] rightDiagonals;

	public List<List<String>> solveNQueens(int n) {
		// 初始化以下被攻击位置的容器，用数组比hashset性能更好
		this.cols = new int[n];
		// 两个对角线总计为2n-1个;左对角线的索引为行列索引之和；右对角线所以为行列之差+n-1；
		this.leftDiagonals = new int[2 * n - 1];
		this.rightDiagonals = new int[2 * n - 1];

		// 从第1行开始执行
		this.solveNQueens0(0, new int[n]);
		return results;
	}

	/**
	 * 将result转换成要求的字符串格式
	 * 
	 * @param result
	 * @return
	 */
	private List<String> buildResult(int[] result) {
		List<String> strRet = new ArrayList<>();

		for (int i = 0; i < result.length; i++) {
			StringBuilder line = new StringBuilder();

			for (int j = 0; j < result.length; j++) {
				if (j == result[i]) {
					line.append("Q");
				} else {
					line.append(".");
				}
			}

			strRet.add(line.toString());
		}

		return strRet;
	}

	/**
	 * 指定位置是否处于被攻击位置
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	private boolean isUnderAttack(int row, int col) {
		if (cols[col] == 1 || leftDiagonals[row + col] == 1 || rightDiagonals[row - col + cols.length - 1] == 1) {
			return true;
		}

		return false;
	}

	/**
	 * 在指定位置放上皇后，result索引为行号，值是列索引，并标记其可攻击的位置，可攻击的位置标记为1
	 * 
	 * @param row
	 * @param col
	 * @param result
	 */
	private void putQueen(int row, int col, int[] result) {
		result[row] = col;

		cols[col] = 1;
		leftDiagonals[row + col] = 1;
		rightDiagonals[row - col + cols.length - 1] = 1;
	}

	/**
	 * 在指定位置移出皇后，并移出其可攻击的位置
	 * 
	 * @param row
	 * @param col
	 * @param result
	 */
	private void removeQueen(int row, int col, int[] result) {
		result[row] = 0;

		cols[col] = 0;
		leftDiagonals[row + col] = 0;
		rightDiagonals[row - col + cols.length - 1] = 0;
	}

	/**
	 * 在指定行，尝试摆放皇后，
	 * 
	 * @param row
	 * @param result
	 */
	private void solveNQueens0(int row, int[] result) {
		for (int col = 0; col < result.length; col++) {
			// 当前位置会被攻击，忽略
			if (this.isUnderAttack(row, col)) {
				continue;
			}

			// 当前位置摆放皇后
			this.putQueen(row, col, result);

			boolean lastRow = row == result.length - 1;
			if (lastRow) {
				// 如果是最后一行，说明当前result是一个合法结果，存放到最终结果集里
				List<String> strResult = this.buildResult(result);
				this.results.add(strResult);
			} else {
				// 还有后续行，尝试去下一行继续摆放皇后
				this.solveNQueens0(row + 1, result);
			}

			// 当前位置对应的结果都已经检索完成，将皇后移出
			this.removeQueen(row, col, result);

			// 如果是最后一行，后续列无须判断
			if (lastRow) {
				break;
			}
		}
	}
}