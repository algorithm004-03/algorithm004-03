package com.github.kylefeng.week01;

import org.junit.jupiter.api.Test;

import static com.github.kylefeng.week01.LeetCode_66_038.plusOne;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author kylefeng
 * @time 2019/10/20 15:26
 */
public class LeetCode_66_038_Test {

    @Test
    void testCase() {
        int[] input1 = new int[]{1, 2, 3};
        int[] expect1 = new int[]{1, 2, 4};

        int[] input2 = new int[]{4, 3, 2, 1};
        int[] expect2 = new int[]{4, 3, 2, 2};


        assertThat(plusOne(input1)).isEqualTo(expect1);
        assertThat(plusOne(input2)).isEqualTo(expect2);
    }

    void abnormalTestCase() {
        int[] input1 = new int[]{9, 9};
        int[] expect1 = new int[]{1, 0, 0};

        int[] input2 = new int[]{9};
        int[] expect2 = new int[]{1, 0};

        int[] nullInput = null;
        int[] emptyInput = new int[]{};

        assertThat(plusOne(input1)).isEqualTo(expect1);
        assertThat(plusOne(input2)).isEqualTo(expect2);
        assertThat(plusOne(nullInput)).isNull();
        assertThat(plusOne(emptyInput)).isEmpty();
    }


}
