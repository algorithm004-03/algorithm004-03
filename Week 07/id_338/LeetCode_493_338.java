/**
 * @author Leesen
 * @date 2019/12/1 23:31
 */
public class LeetCode_493_338 {
    public int reversePairs(int[] nums) {
        return reversePairsSub(nums, 0, nums.length - 1);
    }

    private int reversePairsSub(int[] nums, int l, int r) {
        if (l >= r) return 0;

        int m = l + ((r - l) >> 1);
        int res = reversePairsSub(nums, l, m) + reversePairsSub(nums, m + 1, r);

        int i = l, j = m + 1, k = 0, p = m + 1;
        int[] merge = new int[r - l + 1];

        while (i <= m) {
            while (p <= r && nums[i] > 2L * nums[p]) p++;
            res += p - (m + 1);

            while (j <= r && nums[i] >= nums[j]) merge[k++] = nums[j++];
            merge[k++] = nums[i++];
        }

        while (j <= r) merge[k++] = nums[j++];

        System.arraycopy(merge, 0, nums, l, merge.length);

        return res;
    }
}
