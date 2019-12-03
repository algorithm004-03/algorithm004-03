public class Solution
{
    public int Find(int[] nums)
    {
        int start = 0;
        int end = nums.Length - 1;

        while (start <= end)
        {
            var mid = (start + end) / 2;

            if (nums[mid] > nums[mid + 1])
            {
                return mid;
            }
            else if (nums[mid] < nums[end])
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }

        return -1;
    }
}