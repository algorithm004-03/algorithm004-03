

/**
 * @author kelvin
 * @date 2019/12/1 10:40 PM
 */
public class LeetCode_52_568 {
    public int backtrack(int row, int hills, int next_row, int dales, int count, int n) {
        int columns = (1 << n) - 1;

        if (row == n) {
            count++;
        } else {

            int free_columns = columns & ~(hills | next_row | dales);

            while (free_columns != 0) {

                int curr_column = -free_columns & free_columns;

                free_columns ^= curr_column;

                count = backtrack(row + 1,
                        (hills | curr_column) << 1,
                        next_row | curr_column,
                        (dales | curr_column) >> 1,
                        count, n);
            }
        }

        return count;
    }

    public int totalNQueens(int n) {
        return backtrack(0, 0, 0, 0, 0, n);
    }

}
