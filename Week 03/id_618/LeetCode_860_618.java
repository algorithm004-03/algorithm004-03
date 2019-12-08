class Solution {

	/**
	 * 记录手头5元和10元的数量，每次手帐，增加对应货币，减去找零货币
	 */
	public boolean lemonadeChange(int[] bills) {
		int five = 0;
		int ten = 0;

		for (int bill : bills) {
			if (bill == 5) {
				// 无须找零
				five++;
			} else if (bill == 10) {
				// 找一张5元
				if (five <= 0) {
					return false;
				}

				five--;
				ten++;
			} else if (bill == 20) {
				if (ten <= 0) {
					// 找3张5元
					if (five <= 2) {
						return false;
					} else {
						five = five - 3;
					}
				} else {
					// 找一张10元一张5元
					if (five <= 0) {
						return false;
					} else {
						ten--;
						five--;
					}
				}
			}
		}

		return true;
	}
}