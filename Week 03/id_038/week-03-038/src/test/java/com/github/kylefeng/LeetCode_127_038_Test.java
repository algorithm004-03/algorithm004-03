package com.github.kylefeng;

import org.junit.jupiter.api.Test;

import static com.github.kylefeng.LeetCode_127_038.ladderLength;
import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author kylefeng
 * @time 2019/11/1 16:49
 */
public class LeetCode_127_038_Test {


    @Test
    void testCases() {
        assertEquals(5, ladderLength("hit", "cog", newArrayList("hot", "dot", "dog", "lot", "log", "cog")));
        assertEquals(2, ladderLength("a", "c", newArrayList("a", "b", "c")));
    }

}
