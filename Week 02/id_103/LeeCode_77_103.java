package com.homework.week2;
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法

import java.util.ArrayList;
import java.util.List;

public class LeeCode_77_103 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        getArrs(result,curr,k,1,n);
        return result;
    }

    public static void getArrs(List<List<Integer>> result, List<Integer> curr, int k, int start,int n) {
        if (curr.size() == k) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }

        for (int i = start; i <=n-(k-curr.size())+1; i++) {
            curr.add(i);
            getArrs(result,curr,k,i+1,n);
            curr.remove(curr.size()-1);
        }
    }
}
