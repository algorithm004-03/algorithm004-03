	class Solution {
		public int[] twoSum(int[] nums, int target) {
			int len = nums.length;
			Map<Integer/* value */, Integer/* index */> map = new HashMap<>(len, 1);

			for (int i = 0; i < nums.length; i++) {
				int num = nums[i];
				int goal = target - num;

				Integer idx = map.get(goal);
				if (idx != null) {
					return new int[] { idx, i };
				}

				map.put(num, i);

			}

			return null;
		}
	}