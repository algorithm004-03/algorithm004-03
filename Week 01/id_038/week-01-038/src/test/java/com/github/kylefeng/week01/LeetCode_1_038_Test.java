package com.github.kylefeng.week01;

import org.junit.jupiter.api.Test;

import static com.github.kylefeng.week01.LeetCode_1_038.twoSum;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author kylefeng
 * @time 2019/10/20 16:39
 */
public class LeetCode_1_038_Test {

    @Test
    void testCases() {
        // Given
        int[] nums1 = new int[]{2, 7, 11, 15};
        int target1 = 9;
        int[] expected1 = new int[]{0, 1};

        int[] nums2 = new int[]{1, 1};
        int target2 = 2;
        int[] expected2 = new int[]{0, 1};

        // When
        int[] r1 = twoSum(nums1, target1);
        int[] r2 = twoSum(nums2, target2);

        // Then
        assertThat(r1).isEqualTo(expected1);
        assertThat(r2).isEqualTo(expected2);
    }
}
