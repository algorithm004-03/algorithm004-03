/*
A* 搜索解决

 */

import java.util.*;

class Solution {

    private class State implements Comparable<State> {
        int pos;        // 0在的位置
        int steps;      // 当前状态经历的步数
        int[][] board;  // 当前状态

        @Override
        public int hashCode() {
            return (pos << 16) | steps;
        }

        @Override
        public boolean equals(Object obj) {
            State sta = (State)obj;

            if (pos != sta.pos || steps != sta.steps) {
                return false;
            }

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] != sta.board[i][j]) {
                        return false;
                    }
                }
            }

            return true;
        }

        @Override
        public int compareTo(State o) {
            int num1 = steps + Math.abs(1 - (pos/3)) + Math.abs(2 - (pos%3));
            int num2 = o.steps + Math.abs(1 - (o.pos/3)) + Math.abs(2 - (o.pos%3));
            return num1 - num2;
        }

        public State(int pos, int steps, int[][] board) {
            this.pos = pos;
            this.steps = steps;
            this.board = new int[2][3];

            copyBoard(board, this.board);
        }
    }

    private boolean isEndState(State sta) {
        int[][] ans = new int[][] {{1,2,3},{4,5,0}};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (ans[i][j] != sta.board[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private void copyBoard(int[][] oldBoard, int[][] newBoard) {
        for (int i = 0; i < 2; i++) {
            System.arraycopy(oldBoard[i], 0, newBoard[i], 0, 3);
        }
    }

    private List<State> getNewState(State curSta) {
        List<State> result = new ArrayList<>(4);

        int i = curSta.pos / 3, j = curSta.pos % 3;
        // 0向四个方向移动
        if (i != 0) {
            State newState = new State(j, curSta.steps+1, curSta.board);
            int tmp = newState.board[i][j]; newState.board[i][j] = newState.board[i-1][j]; newState.board[i-1][j] = tmp;
            result.add(newState);
        }

        if (i != 1) {
            State newState = new State(3 + j, curSta.steps+1, curSta.board);
            int tmp = newState.board[i][j]; newState.board[i][j] = newState.board[i+1][j]; newState.board[i+1][j] = tmp;
            result.add(newState);
        }

        if (j > 0) {
            State newState = new State(3*i + (j-1), curSta.steps+1, curSta.board);
            int tmp = newState.board[i][j]; newState.board[i][j] = newState.board[i][j-1]; newState.board[i][j-1] = tmp;
            result.add(newState);
        }

        if (j < 2) {
            State newState = new State(3*i + (j+1), curSta.steps+1, curSta.board);
            int tmp = newState.board[i][j]; newState.board[i][j] = newState.board[i][j+1]; newState.board[i][j+1] = tmp;
            result.add(newState);
        }

        return result;
    }

    public int slidingPuzzle(int[][] board) {
        PriorityQueue<State> heap = new PriorityQueue<>();
        int zeroPos = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    zeroPos = i* 3 + j;
                }
            }
        }

        Set<State> visited = new HashSet<>();
        State initState = new State(zeroPos, 0, board);
        if (isEndState(initState)) {
            return 0;
        }


        heap.add(initState);
        visited.add(initState);
        while (!heap.isEmpty()) {
            State curSta = heap.poll();

            // 0向四个方向移动
            for (State newState : getNewState(curSta)) {
                // 检查如果出现过更好的状态，当前的状态就是无用的
                int steps = newState.steps;
                boolean useless = false;
                while (newState.steps >= 0) {
                    if (visited.contains(newState)) {
                        useless = true;
                        break;
                    }
                    newState.steps--;
                }

                if (useless) {
                    continue;
                }

                newState.steps = steps;

                if (isEndState(newState)) {
                    return newState.steps;
                }

                heap.add(newState);
                visited.add(newState);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println( new Solution().slidingPuzzle(new int[][] {{1,2,3},{5, 4, 0}}));
    }
}
