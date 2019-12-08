<?php
/**
 * Created by IntelliJ IDEA.
 * User: lvliangbo@gmail.com
 * Date: 2019/12/01
 * Time: 21:00:24
 */

function quick_sort($a)
{
    if (count($a) <= 1) {
        return $a;
    }

    $middle = $a[0];
    $left = array();
    $right = array();

    for ($i = 1; $i < count($a); $i++) {
        if ($middle < $a[$i]) {
            $right[] = $a[$i];
        } else {
            $left[] = $a[$i];
        }
    }

    $left = quick_sort($left);
    $right = quick_sort($right);

    return array_merge($left, array($middle), $right);
}
