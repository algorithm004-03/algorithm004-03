public class Solution
{
    public int FindMin(int[] nums)
    {
        int start = 0;
        int end = nums.Length - 1;

        while (start < end)
        {
            int mid = (start + end) / 2;

            if (nums[mid] > nums[mid + 1])
            {
                return nums[mid + 1];
            }
            else
            {
                if (nums[start] > nums[mid])
                {
                    end = mid;
                }
                else if (nums[mid] > nums[end])
                {
                    start = mid;
                }
                else
                {
                    return nums[start];

                }
            }
        }

        return nums[start];
    }
}