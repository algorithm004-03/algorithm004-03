<?php
/**
 * Created by IntelliJ IDEA.
 * User: lvliangbo@gmail.com
 * Date: 2019/11/02
 * Time: 22:36:18
 */

class Solution
{
    private $dx = [-1, 1, 0, 0];
    private $dy = [0, 0, -1, 1];
    private $g;

    /**
     * @param String[][] $grid
     * @return Integer
     */
    function numIslands($grid)
    {
        $islands = 0;
        $this->g = $grid;

        for ($i = 0; $i < count($grid); $i++) {
            for ($j = 0; $j < count($grid[$i]); $j++) {
                if ($this->g[$i][$j] == 0) {
                    continue;
                }

                $islands += $this->sink($i, $j);
            }
        }

        return $islands;
    }

    private function sink($i, $j)
    {
        if ($this->g[$i][$j] == 0) {
            return 0;
        }

        $this->g[$i][$j] = 0;

        for ($k = 0; $k < count($this->dx); $k++) {
            $x = $i + $this->dx[$k];
            $y = $j + $this->dy[$k];

            if ($x >= 0 && $x < count($this->g) && $y >= 0 && $y < count($this->g[$i])) {
                if ($this->g[$x][$y] == 0) {
                    continue;
                }

                $this->sink($x, $y);
            }
        }

        return 1;
    }
}

$s = new Solution();
$grid = [
    [1, 1, 0, 0, 0],
    [1, 1, 0, 0, 0],
    [0, 0, 1, 0, 0],
    [0, 0, 0, 1, 1],
];

$result = $s->numIslands($grid);

echo $result;