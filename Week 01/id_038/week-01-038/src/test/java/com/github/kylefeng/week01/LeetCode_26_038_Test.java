package com.github.kylefeng.week01;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 26. 删除排序数组中的重复项 - 测试用例
 *
 * @author kylefeng
 * @time 2019/10/19 09:21
 */
public class LeetCode_26_038_Test {

    @Test
    void official_test_case_1() {
        int[] input = new int[]{1, 1, 2};
        int[] expected = new int[]{1, 2};

        int len = LeetCode_26_038.removeDuplicates(input);

        assertThat(len).isEqualTo(2);
        assertThat(Arrays.copyOfRange(input, 0, len)).isEqualTo(expected);
    }

    @Test
    void official_test_case_2() {
        int[] input = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] expected = new int[]{0, 1, 2, 3, 4};

        int len = LeetCode_26_038.removeDuplicates(input);

        assertThat(len).isEqualTo(5);
        assertThat(Arrays.copyOfRange(input, 0, len)).isEqualTo(expected);
    }

    @Test
    void abnormal_test_cases() {
        int[] nullInput = null;
        assertThat(LeetCode_26_038.removeDuplicates(nullInput)).isZero();

        int[] emptyInput = new int[]{};
        assertThat(LeetCode_26_038.removeDuplicates(emptyInput)).isZero();

        int[] oneInput = new int[]{1};
        LeetCode_26_038.removeDuplicates(oneInput);
        assertThat(oneInput).isEqualTo(new int[]{1});

        int[] twoSameElements = new int[]{1, 1};
        int len = LeetCode_26_038.removeDuplicates(twoSameElements);
        assertThat(len).isOne();
        assertThat(Arrays.copyOfRange(twoSameElements, 0, len)).isEqualTo(new int[]{1});
    }


}
