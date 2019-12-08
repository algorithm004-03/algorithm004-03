package com.github.kylefeng.week02;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.kylefeng.week02.Helper.TreeNode;
import static com.github.kylefeng.week02.LeetCode_94_038.inorderTraversal;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author kylefeng
 * @time 2019/10/26 16:11
 */
public class LeetCode_94_038_Test {

    @Test
    void testCases() {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        root.right = n1;
        n1.left = n2;

        List<Integer> result = inorderTraversal(root);

        assertThat(result).isEqualTo(Lists.newArrayList(1, 3, 2));
    }

}
