<?php
/**
 * Created by IntelliJ IDEA.
 * User: lvliangbo
 * Date: 2019/10/20
 * Time: 01:52:36
 */

class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function removeDuplicates(&$nums) {
        if (count($nums) == 0) return 0;

        for ($i = 0, $j = 1; $j < count($nums); $j++) {
            if ($nums[$i] != $nums[$j]) {
                $i++;
                $nums[$i] = $nums[$j];
            }
        }

        return $i + 1;
    }
}
