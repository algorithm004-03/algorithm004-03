package com.github.kylefeng.week01;

import org.junit.jupiter.api.Test;

import static com.github.kylefeng.week01.LeetCode_283_038.moveZeroes;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author kylefeng
 * @time 2019/10/20 16:07
 */
public class LeetCode_283_038_Test {

    @Test
    void testCases() {
        // Given
        int[] input = new int[]{0, 1, 0, 3, 12};
        int[] expected = new int[]{1, 3, 12, 0, 0};

        // When
        moveZeroes(input);

        // Then
        assertThat(input).isEqualTo(expected);
    }

    @Test
    void abnormalTestCases() {
        // Given
        int[] nullInput = null;
        int[] emptyInput = new int[]{};
        int[] singleElement = new int[]{Integer.MAX_VALUE};

        // When
        moveZeroes(nullInput);
        moveZeroes(emptyInput);
        moveZeroes(singleElement);

        // Then
        assertThat(nullInput).isNull();
        assertThat(emptyInput).isEmpty();
        assertThat(singleElement).isEqualTo(new int[]{Integer.MAX_VALUE});
    }


}
