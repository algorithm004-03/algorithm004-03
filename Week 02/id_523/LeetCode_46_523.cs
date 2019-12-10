public class Solution
{
    public IList<IList<int>> Permute(int[] nums)
    {
        List<IList<int>> result = new List<IList<int>>();
        for (int i = 0; i < nums.Length; i++)
        {
            Find(result, nums, new List<int> { nums[i] });
        }

        return result;
    }

    static void Find(List<IList<int>> result, int[] nums, List<int> currentList)
    {
        if (currentList.Count == nums.Length)
        {
            result.Add(new List<int>(currentList));
            return;
        }
        foreach (var item in nums)
        {
            if (!currentList.Contains(item))
            {
                currentList.Add(item);
                Find(result, nums, currentList);
                currentList.RemoveAt(currentList.Count - 1);
            }
        }
    }
}