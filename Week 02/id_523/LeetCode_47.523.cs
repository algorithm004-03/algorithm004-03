public class Solution
{
    public IList<IList<int>> PermuteUnique(int[] nums)
    {
        nums = nums.OrderBy(q => q).ToArray();

        List<IList<int>> result = new List<IList<int>>();

        Find(result, nums, new List<int> { });

        return result;
    }

    static void Find(List<IList<int>> result, int[] nums, List<int> currentList)
    {
        if (currentList.Count == nums.Length)
        {
            result.Add(currentList.Select(q => nums[q]).ToList());
            return;
        }

        for (int i = 0; i < nums.Length; i++)
        {
            if (currentList.Contains(i)) continue;

            if (i > 0 && nums[i - 1] == nums[i] && !currentList.Contains(i - 1)) continue;

            currentList.Add(i);
            Find(result, nums, currentList);

            currentList.RemoveAt(currentList.Count - 1);
        }
    }
}