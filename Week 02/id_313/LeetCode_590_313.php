<?php
/*
// Definition for a Node.
class Node {
    public $val;
    public $children;

    @param Integer $val 
    @param list<Node> $children 
    function __construct($val, $children) {
        $this->val = $val;
        $this->children = $children;
    }
}

*/
class Solution {
    public $ret = [];
    /**
     * @param Node $root
     * @return Integer[]
     */
    function postorder($root) {
        if ($root == null) return [];
        foreach($root->children as $child) {
            $this->postorder($child);
        }
        $this->ret[] = $root->val;
        return $this->ret;
    }
}