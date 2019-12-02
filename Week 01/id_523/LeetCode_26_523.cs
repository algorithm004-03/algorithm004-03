public class Solution
{
    public int RemoveDuplicates(int[] nums)
    {
        if (nums.Length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.Length; j++)
        {
            if (nums[j] == nums[i])
            {
                continue;
            }
            else
            {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}