public class Solution
{
    public void MoveZeroes(int[] nums)
    {
        int zeroIndex = MoveToZero(nums, 0);

        for (int i = 0; i < nums.Length && zeroIndex < nums.Length; i++)
        {
            if (nums[i] != 0 && i > zeroIndex)
            {
                nums[zeroIndex] = nums[i];
                nums[i] = 0;
                zeroIndex = MoveToZero(nums, zeroIndex);
            }
        }
    }

    private int MoveToZero(int[] nums, int currentIndex)
    {
        while (currentIndex < nums.Length && nums[currentIndex] != 0)
        {
            currentIndex++;
        }

        return currentIndex;
    }
}