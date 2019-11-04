package com.github.kylefeng;

import org.junit.jupiter.api.Test;

import static com.github.kylefeng.LeetCode_860_038.lemonadeChange;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author kylefeng
 * @time 2019/11/1 17:51
 */
public class LeetCode_860_038_Test {

    @Test
    void testCases() {
        int[] in1 = new int[]{5, 5, 10};
        int[] in2 = new int[]{10, 10};
        int[] in3 = new int[]{5, 5, 10, 10, 20};
        int[] in4 = new int[]{5, 5, 5, 10, 20};
        int[] in5 = new int[]{5, 5, 5, 10, 5, 20, 5, 10, 5, 20};
        int[] in6 = new int[]{5, 5, 5, 5, 10, 5, 10, 10, 10, 20};

        assertTrue(lemonadeChange(in1));
        assertFalse(lemonadeChange(in2));
        assertFalse(lemonadeChange(in3));
        assertTrue(lemonadeChange(in4));
        assertTrue(lemonadeChange(in5));
        assertTrue(lemonadeChange(in6));

    }


}
