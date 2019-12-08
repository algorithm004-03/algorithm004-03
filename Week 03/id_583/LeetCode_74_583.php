<?php
/**
 * Created by IntelliJ IDEA.
 * User: lvliangbo@gmail.com
 * Date: 2019/11/03
 * Time: 21:52:48
 */

class Solution {

    /**
     * @param Integer[][] $matrix
     * @param Integer $target
     * @return Boolean
     */
    function searchMatrix($matrix, $target) {
        //先找到 target 所在的行
        $target_line = count($matrix) - 1;

        while ($matrix[$target_line][0] > $target && $target_line >= 0) {
            $target_line = $target_line - 1;
        }

        $left = 0;
        $right = count($matrix[$target_line]) - 1;

        //执行二分查找算法
        while ($left <= $right) {
            $mid = intval(($left + $right) / 2);

            if ($matrix[$target_line][$mid] == $target) {
                return true;
            } elseif ($matrix[$target_line][$mid] < $target) {
                $left = $mid + 1;
            } else {
                $right = $mid - 1;
            }
        }

        return false;
    }
}

$s = new Solution();
$matrix = [
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50],
];

$target = 24;

$result = $s->searchMatrix($matrix, $target);

echo $result;