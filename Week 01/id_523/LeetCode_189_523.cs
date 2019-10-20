public class Solution
{
    public void Rotate(int[] nums, int k)
    {
        var length = nums.Length;
        k = k % length;
        Reverse(nums, 0, length - 1);
        Reverse(nums, 0, k - 1);
        Reverse(nums, k, length - 1);

    }

    private void Reverse(int[] nums, int start, int end)
    {
        while (start < end)
        {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }
}