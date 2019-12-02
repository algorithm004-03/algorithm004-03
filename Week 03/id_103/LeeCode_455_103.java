package com.homework.week3;

import java.util.Arrays;

public class LeeCode_455_103 {

    public int findContentChildren(int[] g, int[] s) {
        //首先对两个数组进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        //孩子数组下标与饼干数组下标
        int gIndex = 0;
        int sIndex = 0;
        while (gIndex < g.length && sIndex < s.length) {
            //说明第sIndex块饼干能满足第gIndex个孩子的胃口
            if (g[gIndex] <= s[sIndex]) {
                gIndex++;
            }
            //寻求第sIndex+1块饼干的满足情况
            sIndex++;
        }
        return gIndex;
    }
}
