package com.github.kylefeng;

import org.junit.jupiter.api.Test;

import static com.github.kylefeng.LeetCode_153_038.findMin;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author kylefeng
 * @time 2019/11/3 22:04
 */
public class LeetCode_153_038_Test {
    @Test
    void testCase() {
        int[] input1 = new int[]{3, 4, 5, 1, 2};
        int[] input2 = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] input3 = new int[]{1, 2};
        assertEquals(1, findMin(input1));
        assertEquals(0, findMin(input2));
        assertEquals(1, findMin(input3));
    }
}
