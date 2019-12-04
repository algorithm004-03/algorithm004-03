<?php
/**
 * Created by IntelliJ IDEA.
 * User: lvliangbo
 * Date: 2019/10/20
 * Time: 02:06:49
 */

class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        $result = [];

        foreach ($nums as $key => $num) {
            $diff = $target - $num;

            if (!isset($result[$diff])) {
                $result[$num] = $key;
                continue;
            }

            return [$result[$diff], $key];
        }
    }
}
