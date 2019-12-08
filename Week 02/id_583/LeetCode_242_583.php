<?php

class Solution {

    /**
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    function isAnagram($s, $t) {
        if (strlen($s) != strlen($t)) {
            return false;
        }

        $a1 = array_count_values(str_split($s));
        $a2 = array_count_values(str_split($t));

        if (count($a1) != count($a2)) {
            return false;
        }

        foreach($a1 as $key => $val) {
            if ($val != $a2[$key]) {
                return false;
            }
        }

        return true;
    }
}