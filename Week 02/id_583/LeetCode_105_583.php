<?php

class Solution
{
    private $inmap;
    private $preindex = 0;
    private $preorder;
    private $inorder;

    /**
     * @param Integer[] $preorder
     * @param Integer[] $inorder
     * @return TreeNode
     */
    function buildTree($preorder, $inorder)
    {
        $this->preorder = $preorder;
        $this->inorder = $inorder;
        $this->inmap = array_flip($inorder);
        return $this->helper(0, count($inorder) - 1);
    }

    function helper($start, $end)
    {
        if ($start > $end) {
            return;
        }
        $nodeval = $this->preorder[$this->preindex];
        $inindex = $this->inmap[$nodeval];
        $node = new TreeNode($nodeval);
        $this->preindex++;

        $node->left = $this->helper($start, $inindex - 1);
        $node->right = $this->helper($inindex + 1, $end);
        return $node;
    }
}