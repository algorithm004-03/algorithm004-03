package com.github.kylefeng.week02;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.kylefeng.week02.Helper.TreeNode;
import static com.github.kylefeng.week02.LeetCode_144_038.preorderTraversal;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author kylefeng
 * @time 2019/10/26 22:01
 */
public class LeetCode_144_038_Test {

    @Test
    void testCases() {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        root.right = n1;
        n1.left = n2;

        List<Integer> result = preorderTraversal(root);

        assertThat(result).isEqualTo(Lists.newArrayList(1, 2, 3));

    }
}
