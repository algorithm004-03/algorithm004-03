/*
 * Enmotech.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 */

package com.github.kylefeng;

import org.junit.jupiter.api.Test;

import static com.github.kylefeng.LeetCode_64_038.solution_by_brutal;
import static com.github.kylefeng.LeetCode_64_038.solution_by_dp;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author kylefeng
 * @time 2019/11/15 13:14
 */
public class LeetCode_64_038_Test {

    @Test
    void brutal_solution() {
        assertEquals(7, solution_by_brutal(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }

    @Test
    void dp_solution() {
        assertEquals(7, solution_by_dp(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }

}
