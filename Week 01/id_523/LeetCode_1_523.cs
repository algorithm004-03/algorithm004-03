public class Solution
{
    public int[] TwoSum(int[] nums, int target)
    {
        Hashtable hash = new Hashtable();
        for (int i = 0; i < nums.Length; i++)
        {
            if (hash.Contains(target - nums[i]))
            {
                return new int[] { i, (int)hash[target - nums[i]] };
            }
            if (!hash.Contains(nums[i]))
                hash.Add(nums[i], i);
        }

        return new int[] { };
    }
}