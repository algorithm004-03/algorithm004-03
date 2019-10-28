package com.github.kylefeng.week02;

import org.junit.jupiter.api.Test;

import static com.github.kylefeng.week02.LeetCode_242_038.isAnagram;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author kylefeng
 * @time 2019/10/26 10:34
 */
public class LeetCode_242_038_Test {


    @Test
    void testCases() {
        String A1 = "anagram";
        String A2 = "nagaram";
        String B1 = "rat";
        String B2 = "car";
        String C1 = "ccac";
        String C2 = "aacc";

        assertThat(isAnagram(A1, A2)).isTrue();
        assertThat(isAnagram(B1, B2)).isFalse();
        assertThat(isAnagram(C1, C2)).isFalse();
    }

    @Test
    void abnormalTestCases() {
        String nullStr = null;
        String empty = "";

        String diffLen1 = "abc";
        String diffLen2 = "ab";


        assertThat(isAnagram(nullStr, nullStr)).isTrue();
        assertThat(isAnagram(empty, empty)).isTrue();
        assertThat(isAnagram(nullStr, empty)).isFalse();
        assertThat(isAnagram(empty, nullStr)).isFalse();
        assertThat(isAnagram(diffLen1, diffLen2)).isFalse();


    }
}
