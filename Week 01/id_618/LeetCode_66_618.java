	class Solution {
		public int[] plusOne(int[] digits) {
			int i = digits.length - 1;

			while (true) {
				int digit = digits[i];
				digit = (digit + 1) % 10;
				digits[i] = digit;

				if (digit != 0) {
					return digits;
				}

				i--;

				if (i < 0) {
					break;
				}
			}

			int[] ret = new int[digits.length + 1];
			ret[0] = 1;

			return ret;
		}
	}