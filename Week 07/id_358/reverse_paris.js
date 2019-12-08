/**使用归并排序
 * 数组分成左右两个子数组，在merge过程中，设下标i,j 满足nums[i]/2 > nums[j],右侧移动j，统计循环i这一轮中满足的重要对个数为 j-mid+1(j从mid+1开始，i从0 开始)
 * 最后累加个数。
 * @param {number[]} nums
 * @return {number}
 */
 var reversePairs = function(nums) {
    const count = merge_sort(nums,0, nums.length - 1)

    function merge_sort(nums, start, end) {
        if(start>=end) return 0;
        let mid = start + Math.floor((end - start)/2)
        let cnt = merge_sort(nums, start, mid) + merge_sort(nums, mid+1, end)
        for(let i = start, j = mid+1; i<=mid; i++) {
            while(j<=end && nums[i]/2 > nums[j]){
                j++;
            }
            cnt += j - (mid + 1);
        }
        myMerge(nums, start, mid, end)
        return cnt;
    }

    function myMerge(nums, start, mid, end) {
        let temp = [];
        let i = start, j = mid+1, k = 0;
        while(i <= mid && j <= end) {
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++]
        }
        while(i <= mid) temp[k++] = nums[i++]
        while(j <= end) temp[k++] = nums[j++]
        for(let p = 0; p < end - start +1; p++) {
            nums[start+p] = temp[p]
        }
    }
    return count;
};