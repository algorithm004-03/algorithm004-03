<?php
/**
 * Created by IntelliJ IDEA.
 * User: lvliangbo
 * Date: 2019/10/20
 * Time: 21:47:00
 */

class Solution {

    /**
     * @param Integer[] $nums
     * @return NULL
     */
    function moveZeroes(&$nums) {
        $j = 0;
        for ($i = 0; $i < count($nums); $i++) {
            if ($nums[$i] != 0) {
                $nums[$j] = $nums[$i];
                if ($i != $j) {
                    $nums[$i] = 0;
                }

                $j++;
            }

        }
    }
}