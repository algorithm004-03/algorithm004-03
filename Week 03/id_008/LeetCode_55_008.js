/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
	var canJump0List = [];

	for (var i = 0; i < nums.length - 1; ++i) {
		if (nums[i] === 0) {
			var canJump0 = false;

			for (var j = i - 1; j >= 0; --j) {
				if (nums[j] > i - j) {
					canJump0 = true;
					break;
				}
			}

			canJump0List.push(canJump0);
		}
	}

	for (var i = 0; i < canJump0List.length; ++i) {
		if (!canJump0List[i]) {
			return false;
		}
	}

	return true;
};
