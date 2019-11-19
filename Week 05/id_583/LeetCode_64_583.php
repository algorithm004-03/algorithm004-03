<?php
/**
 * Created by IntelliJ IDEA.
 * User: lvliangbo@gmail.com
 * Date: 2019/11/19
 * Time: 20:58:15
 */

class Solution
{
    /**
     * @param Integer[][] $grid
     * @return Integer
     */
    function minPathSum($grid)
    {
        for ($i = count($grid) - 1; $i >= 0; $i--) {
            for ($j = count($grid[0]) - 1; $j >= 0; $j--) {
                if ($i == count($grid) - 1 && $j != count($grid[0]) - 1)
                    $grid[$i][$j] = $grid[$i][$j] + $grid[$i][$j + 1];
                else if ($j == count($grid[0]) - 1 && $i != count($grid) - 1)
                    $grid[$i][$j] = $grid[$i][$j] + $grid[$i + 1][$j];
                else if ($j != count($grid[0]) - 1 && $i != count($grid) - 1)
                    $grid[$i][$j] = $grid[$i][$j] + min($grid[$i + 1][$j], $grid[$i][$j + 1]);
            }
        }
        return $grid[0][0];
    }
}

$s = new Solution();
$grid = [
    [1, 3, 1],
    [1, 5, 1],
    [4, 2, 1]
];

$result = $s->minPathSum($grid);

echo $result;