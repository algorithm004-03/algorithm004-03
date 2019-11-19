
/*
思路

先把棋盘遍历一遍, 把每一个空格可能出现的数值都统计出来，
然后把空格根据能填的数值多少进行排序，从能填的数值少的
空格开始进行递归遍历，方便进行减枝
*/



import java.util.*;


class Solution {
    private class Node implements Comparable<Node> {
        int i;
        int j;
        List<Character> possibleVal;

        Node(int i, int j) {
            this.i = i; this.j = j;
            possibleVal = new ArrayList<>(9);
        }

        @Override
        public int compareTo(Node node) {
            return possibleVal.size() - node.possibleVal.size();
        }
    }

    private boolean initPossibleList(List<Node> nodes, char[][] board) {
        // 统计每一个空格的信息
        Set<Character> helper = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }

                helper.clear();
                for (int jj = 0; jj < 9; jj++) {
                    if (board[i][jj] != '.') {
                        helper.add(board[i][jj]);
                    }
                }

                for (int ii = 0; ii < 9; ii++) {
                    if (board[ii][j] != '.') {
                        helper.add(board[ii][j]);
                    }
                }

                int start_i = (i/3) * 3;
                int start_j = (j/3) * 3;
                for (int ii = start_i; ii < start_i + 3; ii++) {
                    for (int jj = start_j; jj < start_j + 3; jj++) {
                        if (board[ii][jj] != '.') {
                            helper.add(board[ii][jj]);
                        }
                    }
                }

                Node node = new Node(i, j);
                for (int ii = 0; ii < 9; ii++) {
                    if (!helper.contains((char)('1' + ii))) {
                        node.possibleVal.add((char)('1' + ii));
                    }
                }

                if (node.possibleVal.size() == 0) {
                    return false;
                }
                nodes.add(node);

            }
        }

        nodes.sort(Node::compareTo);
        return true;
    }

    private boolean isConflict(Node node, char ch, char[][] board) {
        // 检查有没有重复的

        for (int ii = 0; ii < 9; ii++) {
            if ((ii != node.i) && (board[ii][node.j] == ch)) {
                return true;
            }
        }

        for (int jj = 0; jj < 9; jj++) {
            if ((jj != node.j) && (board[node.i][jj] == ch)) {
                return true;
            }
        }

        int start_i = (node.i / 3) * 3;
        int start_j = (node.j / 3) * 3;

        for (int ii = start_i; ii < start_i + 3; ii++) {
            for (int jj = start_j; jj < start_j + 3; jj++) {
                if ((ii != node.i) && (jj != node.j) && (board[ii][jj] == ch)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(List<Node> nodes, char[][] board, int curLevel, int maxLevel) {
        if (curLevel == maxLevel) {
            return true;
        }

        Node node = nodes.get(curLevel);

        for (char ch : node.possibleVal) {
            if (isConflict(node, ch, board)) {
                continue;
            }

            board[node.i][node.j] = ch;
            if (dfs(nodes, board, curLevel + 1, maxLevel)) {
                return true;
            }
        }

        board[node.i][node.j] = '.';
        return false;
    }

    public void solveSudoku(char[][] board) {
        List<Node> nodes = new ArrayList<>(81);
        if (!initPossibleList(nodes, board)) {
            return;
        }

        dfs(nodes, board, 0, nodes.size());
    }


    public static void main(String[] args) {
        new Solution().solveSudoku(new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}});
    }

}
