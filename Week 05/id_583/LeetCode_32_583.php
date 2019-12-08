<?php
/**
 * Created by IntelliJ IDEA.
 * User: lvliangbo@gmail.com
 * Date: 2019/11/19
 * Time: 21:30:15
 */

class Solution
{

    /**
     * @param String $s
     * @return Integer
     */
    function longestValidParentheses($s)
    {
        $max = 0;
        $dp = array_fill(0, strlen($s), 0);

        for ($i = 1; $i < strlen($s); $i++) {
            if ($s[$i] == ')') {
                if ($s[$i - 1] == '(') {
                    $dp[$i] = ($i >= 2 ? $dp[$i - 2] : 0) + 2;
                } else if ($i - $dp[$i - 1] > 0 && $s[$i - $dp[$i - 1] - 1] == '(') {
                    $dp[$i] = $dp[$i - 1] + (($i - $dp[$i - 1]) >= 2 ? $dp[$i - $dp[$i - 1] - 2] : 0) + 2;
                }
                $max = max($max, $dp[$i]);
            }
        }
        return $max;
    }
}

$so = new Solution();
$s = '(()';

$result = $so->longestValidParentheses($s);

echo $result;