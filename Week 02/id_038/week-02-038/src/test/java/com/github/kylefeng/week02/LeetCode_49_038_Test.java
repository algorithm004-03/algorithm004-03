package com.github.kylefeng.week02;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import static com.github.kylefeng.week02.LeetCode_49_038.groupAnagrams;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author kylefeng
 * @time 2019/10/27 10:54
 */
public class LeetCode_49_038_Test {

    @Test
    void testCases() {
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Lists.newArrayList();
        List<String> e1 = Lists.newArrayList("ate", "eat", "tea");
        List<String> e2 = Lists.newArrayList("nat", "tan");
        List<String> e3 = Lists.newArrayList("bat");
        expected.add(e1);
        expected.add(e2);
        expected.add(e3);
        List<List<String>> actual = groupAnagrams(input);

        assertTrue(compare(expected, actual));

    }


    static boolean compare(List<List<String>> rs1, List<List<String>> rs2) {
        if (rs1.size() != rs2.size()) {
            return false;
        }

        Comparator<List<String>> comp = new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.size() - o2.size();
            }
        };

        Collections.sort(rs1, comp);
        Collections.sort(rs2, comp);

        for (int i = 0; i < rs1.size(); i++) {
            List<String> elems1 = rs1.get(i);
            List<String> elems2 = rs2.get(i);

            if (!new HashSet<>(elems1).containsAll(elems2)) {
                return false;
            }
        }
        return true;
    }
}
