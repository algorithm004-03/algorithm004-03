class Solution {
	/**
	 * 对于奇数，1的数量比前一个偶数多一个，对于偶数，与其右移一位（即除以2）的数一致，如11100和1110的1数量一致
	 */
	public int[] countBits(int num) {
		int[] result = new int[num + 1];
		result[0] = 0;

		for (int i = 1; i <= num; i++) {
			if ((i & 1) == 1) {
				result[i] = result[i - 1] + 1;
			} else {
				result[i] = result[i >> 1];
			}
		}

		return result;
	}
}