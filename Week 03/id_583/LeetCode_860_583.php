<?php
/**
 * Created by IntelliJ IDEA.
 * User: lvliangbo@gmail.com
 * Date: 2019/11/03
 * Time: 23:22:53
 */

class Solution {

    /**
     * @param Integer[] $bills
     * @return Boolean
     */
    function lemonadeChange($bills) {
        $five = $ten = 0;
        foreach ($bills as $bill) {
            switch ($bill) {
                case 5:
                    $five++;
                    break;
                case 10:
                    if ($five == 0) return false;
                    $five--;
                    $ten++;
                    break;
                default:
                    if ($five > 0 && $ten > 0) {
                        $five--;
                        $ten--;
                    } else if ($five >= 3) {
                        $five -= 3;
                    } else {
                        return false;
                    }
            }
        }

        return true;
    }
}

$s = new Solution();
$bills = [5,5,5,10,20];

$result = $s->lemonadeChange($bills);

echo $result;