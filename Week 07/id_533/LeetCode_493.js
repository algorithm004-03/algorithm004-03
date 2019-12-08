// https://leetcode-cn.com/problems/reverse-pairs/

/**
 * @param {number[]} nums
 * @return {number}
 */
var reversePairs = function (nums) {
    if (!nums || !nums.length) return 0;
    var count = 0;
    mergeSort(nums, 0, nums.length - 1);
    return count;
    function mergeSort (nums, begin, end) {
        if (begin >= end) return;
        var mid = (begin + end) >> 1;
        mergeSort(nums, begin, mid);
        mergeSort(nums, mid + 1, end);
        var tmp = [],
            i1 = begin,
            i2 = begin,
            k = 0;
        for (var j = mid + 1; j <= end; j++) {
            while (i1 <= mid && (nums[i1] / 2) <= nums[j])
                i1++;
            while (i2 <= mid && nums[i2] < nums[j]) 
                tmp[k++] = nums[i2++];
            tmp[k++] = nums[j];
            count += mid - i1 + 1;
        }
        while (i2 <= mid) 
            tmp[k++] = nums[i2++];
        for (var p = 0; p < tmp.length; p++) 
            nums[begin+p] = tmp[p];
    }
};

console.log(reversePairs([1, 3, 2, 3, 1]));
console.log(reversePairs([2, 4, 3, 5, 1]));