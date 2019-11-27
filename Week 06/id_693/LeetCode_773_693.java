package id_693;

import java.util.*;

/**
 * @Author 李雷（KyLin）
 * @Desc 773. 滑动谜题	https://leetcode-cn.com/problems/sliding-puzzle/
 * @Date 2019/11/25
 */
public class LeetCode_773_693 {
    /**
     * BFS搜索
     */
    class Solution {
        public int slidingPuzzle(int[][] board) {
            String startStr = boardToStr(board);
            String endStr = "123450";
            Deque<String> deque = new ArrayDeque<>();
            Set<String> visited = new HashSet<>();
            deque.offer(startStr);
            visited.add(startStr);
            int res = 0;
            int[] dir = new int[]{1,-1,-3,3};
            while (!deque.isEmpty()) {
                for (int size = deque.size(); size > 0; size--) {
                    String temp = deque.poll();
                    if (temp.equals(endStr)) return res;
                    int i = temp.indexOf('0');
                    for (int d : dir) {
                        char[] chars = temp.toCharArray();
                        int j = i + d;
                        //用于避免无效交换的条件
                        if (j < 0 || j >= chars.length || (i == 2 && j == 3) || (i == 3 && j == 2)) {
                            continue;
                        }
                        char t = chars[i];
                        chars[i] = chars[j];
                        chars[j] = t;
                        String s = String.valueOf(chars);
                        if (visited.add(s)) {
                            deque.offer(s);
                        }
                    }
                }
                res++;
            }
            return -1;
        }

        private String boardToStr(int[][] board) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    str.append(board[i][j]);
                }
            }
            return str.toString();
        }
    }

    /**
     * A*搜索 （启发式搜索）TODO
     */
    class Solution2 {
        public int slidingPuzzle(int[][] board) {
            return -1;
        }
    }


    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,3},{4,5,0}};
        System.out.println(Arrays.deepToString(a).replaceAll("\\[|\\]|,|\\s",""));
    }
}
