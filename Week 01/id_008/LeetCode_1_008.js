/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    for (var i = 0; i < nums.length - 1; ++i) {
        for (var j = i + 1; j < nums.length; ++j) {
            if (nums[i] + nums[j] === target) {
                return [i, j]
            }
        }
    }

    return [];
};

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    var clone = nums.slice(0);
    nums.sort(function(a, b){ return a - b; });

    var A = 0, B = nums.length - 1, sum = 0;

    while (A < B) {
        sum = nums[A] + nums[B];

        if (sum > target) {
            --B;
        }
        else if (sum < target) {
            ++A;
        }
        else {
            var a = 0, b = clone.length - 1;

            while (clone[a] != nums[A]) {
                ++a;
            }

            while (clone[b] != nums[B]) {
                --b;
            }

            return [a, b];
        }
    }

    return [];
};
