package com.github.kylefeng.week02;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.kylefeng.week02.Helper.Node;
import static com.github.kylefeng.week02.Helper.node;
import static com.github.kylefeng.week02.LeetCode_590_038.postorder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author kylefeng
 * @time 2019/10/26 22:56
 */
public class LeetCode_590_038_Test {

    @Test
    void testCases() {
        Node root = node(1, node(10, 5, 0), node(3, 6));
        List<Integer> expected = Lists.newArrayList(5, 0, 10, 6, 3, 1);
        List<Integer> actual = postorder(root);
        assertThat(actual).isEqualTo(expected);
    }

}
