package com.company.leetcode.editor.cn;
//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
// count = 1
// 例如，给定三角形：
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
// 说明：
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
// Related Topics 数组 动态规划


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_120 {
    public int minimumTotal(List<List<Integer>> triangle) {

        for (int i = triangle.size() - 2; i >= 0 ; i--) {
            List<Integer> tmp = triangle.get(i + 1);
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int current = triangle.get(i).get(j);
                int nextL = tmp.get(j);
                int nextR = tmp.get(j + 1);
                int res = Math.min(current + nextL,current + nextR);
                triangle.get(i).set(j,res);
            }
        }

        return triangle.get(0).get(0);
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//
//        List<List<Integer>> list = new ArrayList<>();
//        //     [2],
////    [3,4],
////   [6,5,7],
////  [4,1,8,3]
//        List<Integer> l1 = new ArrayList<>();
//        l1.add(2);
//
//        List<Integer> l2 = new ArrayList<>();
//        l2.add(3);
//        l2.add(4);
//
//        List<Integer> l3 = new ArrayList<>();
//        l3.add(6);
//        l3.add(5);
//        l3.add(7);
//
//        List<Integer> l4 = new ArrayList<>();
//        l4.add(4);
//        l4.add(1);
//        l4.add(8);
//        l4.add(3);
//
//        list.add(l1);
//        list.add(l2);
//        list.add(l3);
//        list.add(l4);
//
//        int res = s.minimumTotal(list);
//        System.out.println(res);
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
