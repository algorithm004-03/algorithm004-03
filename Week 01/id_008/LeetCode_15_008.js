/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    nums.sort(function(a, b){ return a - b; });
    var prevI, prevJ, prevK, I = 0, J, K, sum, result = [];

    while (I < nums.length - 2 && nums[I] <= 0) {
        J = I + 1;
        K = nums.length - 1;
        prevI = nums[I];
        prevJ = nums[J];
        prevK = nums[K];

        while (J < K) {
            sum = nums[I] + nums[J] + nums[K];

            if (sum > 0) {
                while (nums[K] === prevK) {
                    --K;
                }

                prevK = nums[K];
            }
            else {
                sum === 0 && result.push([nums[I], nums[J], nums[K]]);

                while (nums[J] === prevJ) {
                    ++J;
                }

                prevJ = nums[J];
            }
        }

        while (nums[I] === prevI) {
            ++I;
        }
    }

    return result;
};
