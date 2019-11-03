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
    function preorder($root) {
        if ($root == null ) return [];
        $this->ret[] = $root->val;
        foreach($root->children as $child) {
            $this->preorder($child);
        }
        return $this->ret;
    }
}