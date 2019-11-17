/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
	if (nums.length <= 1) {
		return 0;
	}

	function findMax(k){
		if (k + nums[k] + 1 >= nums.length) {
			return true;
		}

		var cover = [];

		for (var i = k + 1; i <= k + nums[k]; ++i) {
			cover.push(i + nums[i]);
		}

		var max = 0, maxI = 0;

		for (var i = 0; i < cover.length; ++i) {
			if (cover[i] > cover[maxI]) {
				maxI = i;
				max = cover[i];
			}
		}

		if (maxI + k + 1 >= nums.length - 1) {
			return true;
		}

		return maxI + k + 1;
	}

	var step = 0;
	var currentPoint = 0;

	while (true) {
		currentPoint = findMax(currentPoint);
		++step;

		if (currentPoint === true) {
			break;
		}
	}

	return step;
};
