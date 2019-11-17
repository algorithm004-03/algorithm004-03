/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    var L = 0;
    var R = nums.length - 1;
    var harf = Math.floor((L + R) / 2);

    if (nums.length === 0) {
        return -1;
    }

    if (nums.length === 1) {
        return nums[0] === target ? 0 : -1;
    }

    while (L <= R) {
        if (L === R) {
            if (nums[L] === target) {
                return L;
            }

            return -1;
        }

        if (nums[L] < nums[R]) {
            if (nums[harf] > target) {
                R = harf - 1;
            }
            else if (nums[harf] < target) {
                L = harf + 1;
            }
            else {
                return harf;
            }

            harf = Math.floor((L + R) / 2);
        }
        else {
            if (nums[harf] > target) {
                if (nums[harf] > nums[R] && target < nums[L]) {
                    L = harf + 1;
                }
                else if (nums[harf] > nums[R] && target > nums[R]) {
                    R = harf - 1;
                }
                else if (nums[harf] < nums[L] && target < nums[L]) {
                    R = harf - 1;
                }
            }
            else if (nums[harf] < target) {
                if (nums[harf] < nums[L] && target > nums[R]) {
                    R = harf - 1;
                }
                else if (nums[harf] < nums[L] && target < nums[L]) {
                    L = harf + 1;
                }
                else if (nums[harf] > nums[R] && target > nums[R]) {
                    L = harf + 1;
                }
            }
            else {
                return harf;
            }

            harf = Math.floor((L + R) / 2);
        }
    }

    return -1;
};
