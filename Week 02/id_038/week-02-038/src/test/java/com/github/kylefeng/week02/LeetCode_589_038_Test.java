package com.github.kylefeng.week02;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.kylefeng.week02.Helper.Node;
import static com.github.kylefeng.week02.Helper.node;
import static com.github.kylefeng.week02.LeetCode_589_038.preorder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author kylefeng
 * @time 2019/10/27 10:39
 */
public class LeetCode_589_038_Test {

    @Test
    void testCases() {
        Node root = node(1, node(3, 5, 6), 2, 4);
        List<Integer> expected = Lists.newArrayList(1, 3, 5, 6, 2, 4);
        List<Integer> actual = preorder(root);
        assertThat(actual).isEqualTo(expected);
    }
}
