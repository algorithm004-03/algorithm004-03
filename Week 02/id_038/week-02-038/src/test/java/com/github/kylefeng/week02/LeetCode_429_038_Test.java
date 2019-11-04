package com.github.kylefeng.week02;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.kylefeng.week02.Helper.Node;
import static com.github.kylefeng.week02.Helper.node;
import static com.github.kylefeng.week02.LeetCode_429_038.levelOrder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author kylefeng
 * @time 2019/10/26 11:36
 */
public class LeetCode_429_038_Test {

    @Test
    void testCases() {
        Node tree = node(1, node(3, 5, 6), 2, 4);
        List<List<Integer>> expected = Lists.newArrayList();
        expected.add(Lists.newArrayList(1));
        expected.add(Lists.newArrayList(3, 2, 4));
        expected.add(Lists.newArrayList(5, 6));
        List<List<Integer>> actual = levelOrder(tree);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        Node root = node(1, node(10, 5, 0), node(3, 6));
        List<List<Integer>> expected = Lists.newArrayList();
        expected.add(Lists.newArrayList(1));
        expected.add(Lists.newArrayList(10, 3));
        expected.add(Lists.newArrayList(5, 0, 6));
        List<List<Integer>> actual = levelOrder(root);
        assertThat(actual).isEqualTo(expected);
    }
}
