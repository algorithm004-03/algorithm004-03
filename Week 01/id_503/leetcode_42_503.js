/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function (height) {
	let left = 0;
	let right = height.length - 1;
	let leftMax = rightMax = r = 0;

	while (left < right) {
		if (height[left] < height[right]) {

			const cur = height[left];
			if (cur < leftMax) {
				r += leftMax - cur;
			} else {
				leftMax = cur;
			}

			left++;
		} else {
			const cur = height[right];
			if (cur < rightMax) {
				r += rightMax - cur;
			} else {
				rightMax = cur;
			}

			right--;
		}
	}

	return r;
};