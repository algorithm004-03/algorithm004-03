<?php
/**
 * Created by IntelliJ IDEA.
 * User: lvliangbo@gmail.com
 * Date: 2019/12/01
 * Time: 23:16:58
 */

class Solution {

    /**
     * @param Integer $n
     * @return Boolean
     */
    function isPowerOfTwo($n) {
        return ($n > 0) && ($n & ($n - 1)) == 0;
    }
}

$s = new Solution();
$n = '161';

$result = $s->isPowerOfTwo($n);

echo $result;
