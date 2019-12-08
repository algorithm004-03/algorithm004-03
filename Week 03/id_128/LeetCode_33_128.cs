//一遍二分查找
public class Solution
{
    public int Search(int[] nums, int target)
    {
        if (nums.Length == 0)
            return -1;
        if (nums[0] <= nums[nums.Length - 1])
            return BinarySearch(nums, target, 0, nums.Length - 1);
        else
            return BinarySearch1(nums, target, 0, nums.Length - 1);


    }

    public int BinarySearch(int[] nums, int target, int start, int end)
    {
        while (start <= end)
        {
            int mid = (start + end) / 2;
            if (nums[mid] > target)
            {
                end = mid - 1;
            }
            else if (nums[mid] < target)
            {
                start = mid + 1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }

    public int BinarySearch1(int[] nums, int target, int start, int end)
    {
        if (nums[start] < nums[end])
            return 0;
        int lastValue = nums[end];
        while (start <= end)
        {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > lastValue && target > lastValue)
            {
                if (target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else if (nums[mid] > lastValue && target <= lastValue)
            {
                start = mid + 1;
            }
            else if (nums[mid] < lastValue && target > lastValue)
            {
                end = mid - 1;
            }
            else if (nums[mid] <= lastValue && target <= lastValue)
            {
                if (target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else
            {
                return -1;
            }
        }
        return -1;
    }
}





//先找pivot point 即2遍二分查找
public class Solution
{
    public int Search(int[] nums, int target)
    {
        if (nums.Length == 0) return -1;
        if (nums.Length == 1) return nums[0] == target ? 0 : -1;
        int pivotIndex = FindPivotIndex(nums);
        if (nums[pivotIndex] == target)
            return pivotIndex;
        if (pivotIndex == 0)
            return BinarySearch(nums, target, 0, nums.Length - 1);
        if (target >= nums[0])
            return BinarySearch(nums, target, 0, pivotIndex - 1);
        return BinarySearch(nums, target, pivotIndex, nums.Length - 1);
    }

    private int FindPivotIndex(int[] nums)
    {
        int start = 0;
        int end = nums.Length - 1;
        if (nums[start] < nums[end]) return 0;
        while (start <= end)
        {
            int mid = (start + end) / 2;
            if (nums[mid + 1] <= nums[mid])
            {
                return mid + 1;
            }
            else if (nums[mid] < nums[start])
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return 0;
    }

    public int BinarySearch(int[] nums, int target, int start, int end)
    {
        while (start <= end)
        {
            int mid = (start + end) / 2;
            if (nums[mid] > target)
            {
                end = mid - 1;
            }
            else if (nums[mid] < target)
            {
                start = mid + 1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
}