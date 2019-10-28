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
     * @return Integer[][]
     */
    function levelOrder($root) {
        $this->traverse($root, 0);
        return $this->ret;
    }

    function traverse($root, $depth) {
        if ($root == null) return;
        $this->ret[$depth][] = $root->val;
        foreach($root->children as $child) {
            $this->traverse($child, $depth + 1);
        }
    }
}