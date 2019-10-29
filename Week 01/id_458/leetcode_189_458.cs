public class Solution {
    public void Rotate(int[] nums, int k) {
        if (k > nums.Length)
            k = k % nums.Length;

        for (var i = 0; i < nums.Length / 2; i++)
        {
            swap(nums, i, nums.Length - 1 - i);
        }

        for (var i = 0; i < k / 2; i++)
        {
            swap(nums, i, k - 1 - i);
        }

        for (var i = 0; i < (nums.Length - k) / 2; i++)
        {
            swap(nums, i + k, nums.Length - 1 - i);
        }
    }

    private void swap(int[] nums, int i, int j)
    {
        var temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}