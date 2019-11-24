/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    if (nums.length === 1 || nums[0] < nums[nums.length - 1]) {
        return nums[0];
    }

    if (nums.length === 2) {
        return nums[0] < nums[1] ? nums[0] : nums[1];
    }

    var L = 0;
    var R = nums.length - 2;
    var harf = Math.floor((L + R) / 2);

    while (L <= R) {
        if (nums[harf] > nums[harf + 1]) {
            return nums[harf + 1];
        }

        if (L === R) {
            if (nums[L] > nums[L + 1]) {
                return nums[L + 1];
            }

            return 0;
        }

        if (nums[harf] > nums[R + 1]) {
            L = harf + 1;
        }
        else if (nums[harf + 1] < nums[L]) {
            R = harf - 1;
        }

        harf = Math.floor((L + R) / 2);
    }

    return 0;
};
