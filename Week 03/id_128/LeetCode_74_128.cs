public class Solution
{
    public bool SearchMatrix(int[][] matrix, int target)
    {
        int m = matrix.Length;
        if (m == 0) return false;
        int n = matrix[0].Length;
        int left = 0;
        int right = m * n - 1;

        while (left <= right)
        {
            int midIdx = (left + right) / 2;
            int midValue = matrix[midIdx / n][midIdx % n];
            if (midValue == target)
                return true;
            else if (midValue < target)
                left = midIdx + 1;
            else
                right = midIdx - 1;
        }
        return false;
    }
}