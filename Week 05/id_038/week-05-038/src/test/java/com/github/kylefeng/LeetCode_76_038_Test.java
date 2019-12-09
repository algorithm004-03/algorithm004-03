/*
 * Enmotech.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 */

package com.github.kylefeng;

import org.junit.jupiter.api.Test;

import static com.github.kylefeng.LeetCode_76_038.solution_by_moving_window;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author kylefeng
 * @time 2019/11/15 13:09
 */
public class LeetCode_76_038_Test {

    @Test
    void testSolutionByMovingWindow() {
        assertEquals("BANC", solution_by_moving_window("ADOBECODEBANC", "ABC"));
    }
}
