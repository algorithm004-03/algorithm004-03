package com.github.kylefeng;

import org.junit.jupiter.api.Test;

import static com.github.kylefeng.LeetCode_32_038.solution_brutal;
import static com.github.kylefeng.LeetCode_32_038.solution_dp;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author kylefeng
 * @time 2019/11/13 14:18
 */
public class LeetCode_32_038_Test {

    @Test
    void testCasesForBrutal() {
        assertEquals(2, solution_brutal("(()"));
        assertEquals(4, solution_brutal(")()())"));
    }

    @Test
    void testCasesForDp() {
        assertEquals(2, solution_dp("(()"));
        assertEquals(4, solution_dp(")()())"));
    }

}
