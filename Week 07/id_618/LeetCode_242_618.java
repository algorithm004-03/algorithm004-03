class Solution {
	public boolean isAnagram(String s, String t) {
		// 长度不一致，肯定不是
		if (s.length() != t.length()) {
			return false;
		}

		// 利用字符的asc2编码作为索引
		int[] map = new int[256];

		// 遍历s,记录每个字符出现的次数
		for (char c : s.toCharArray()) {
			int num = map[c];
			num++;
			map[c] = num;
		}

		// 遍历t,从map中找到对应字符，找到则减去出现的次数
		for (char c : t.toCharArray()) {
			int num = map[c];

			if (num == 0) {
				// 不存在直接说明肯定不匹配
				return false;
			} else {
				num--;
			}

			map[c] = num;
		}

		// map中都是0，说明匹配，反之不匹配
		for (int i = 0; i < map.length; i++) {
			if (map[i] != 0) {
				return false;
			}
		}

		return true;
	}
}