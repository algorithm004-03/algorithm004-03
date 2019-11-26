package com.github.kylefeng.week01;

import com.github.kylefeng.week01.LeetCode_21_038.ListNode;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author kylefeng
 * @time 2019/10/19 22:25
 */
public class LeetCode_21_038_Test {

    @Test
    void testCases() {
        ListNode list1 = LeetCode_21_038.newLinkedList(1, 2, 4);
        ListNode list2 = LeetCode_21_038.newLinkedList(1, 3, 4);
        ListNode merged = LeetCode_21_038.mergeTwoLists(list1, list2);
        assertThat(LeetCode_21_038.linkedListToList(merged)).isEqualTo(Lists.newArrayList(1, 1, 2, 3, 4, 4));
    }
}
