public class Solution
{
    public bool SearchMatrix(int[,] matrix, int target)
    {
        var row = matrix.GetLength(0);
        var column = matrix.GetLength(1);

        if (column == 0) return false;

        for (int i = row - 1; i >= 0; i--)
        {
            if (target >= matrix[i, 0])
            {
                for (int j = 0; j < column; j++)
                {
                    if (matrix[i, j] == target)
                    {
                        return true;
                    }
                }

                return false;
            }
        }

        return false;
    }
}