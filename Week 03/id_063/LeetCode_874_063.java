/*
思路

简单进行模拟

 */

class Solution {
    private Map<Integer, List<Integer>> obs_row;
    private Map<Integer, List<Integer>> obs_col;

    private class Pos {
        int i;
        int j;
        Pos(int i, int j) {
            this.i = i; this.j = j;
        }
    }

    private void buildObs(int[][] obstacles) {
        obs_row = new HashMap<>();
        obs_col = new HashMap<>();

        for (int i = 0; i < obstacles.length; i++) {
            List<Integer> l = obs_row.getOrDefault(obstacles[i][1], new LinkedList<>());
            l.add(obstacles[i][0]);
            obs_row.put(obstacles[i][1], l);

            l = obs_col.getOrDefault(obstacles[i][0], new LinkedList<>());
            l.add(obstacles[i][1]);
            obs_col.put(obstacles[i][0], l);
        }
    }

    private void moveUp(Pos pos, int steps) {
        int start = pos.i + 1;
        int end = pos.i + steps;
        int target = Integer.MAX_VALUE;
        boolean findObs = false;

        for (int obs_i : obs_col.getOrDefault(pos.j, new LinkedList<>())) {
            if ( (obs_i >= start && obs_i <= end) ) {
                findObs = true;
                target = Math.min(target, obs_i);
            }
        }

        pos.i = findObs ? (target - 1) : end;
    }

    private void moveDown(Pos pos, int steps) {
        int start = pos.i - steps;
        int end = pos.i-1;
        int target = Integer.MIN_VALUE;
        boolean findObs = false;

        for (int obs_i : obs_col.getOrDefault(pos.j, new LinkedList<>())) {
            if ( (obs_i >= start && obs_i <= end) ) {
                findObs = true;
                target = Math.max(target, obs_i);
            }
        }

        pos.i = findObs ? (target + 1) : start;
    }

    private void moveLeft(Pos pos, int steps) {
        int start = pos.j - steps;
        int end = pos.j-1;
        int target = Integer.MIN_VALUE;
        boolean findObs = false;

        for (int obs_j : obs_row.getOrDefault(pos.i,  new LinkedList<>())) {
            if ( obs_j >= start && obs_j <= end ) {
                findObs = true;
                target = Math.max(target, obs_j);
            }
        }

        pos.j = findObs ? (target + 1) : start;
    }

    private void moveRight(Pos pos, int steps) {
        int start = pos.j+1;
        int end = pos.j + steps;
        int target = Integer.MAX_VALUE;
        boolean findObs = false;

        for (int obs_j : obs_row.getOrDefault(pos.i,  new LinkedList<>())) {
            if ( obs_j >= start && obs_j <= end ) {
                findObs = true;
                target = Math.min(target, obs_j);
            }
        }

        pos.j = findObs ? (target - 1) : end;
    }

    private void moveStep(Pos pos, int direc, int steps) {
        switch (direc) {
            case 0:
                moveUp(pos, steps);
                break;
            case 1:
                moveRight(pos, steps);
                break;
            case 2:
                moveDown(pos, steps);
                break;
            case 3:
                moveLeft(pos,steps);
                break;
            default:
                break;
        }
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        buildObs(obstacles);

        int direc = 0;
        Pos pos = new Pos(0, 0);
        int max = 0;

        for (int cmd : commands) {
            if (cmd == -1) {
                direc = (direc + 1) % 4;
            } else if (cmd == -2) {
                direc = (direc >= 1) ? (direc-1) : 3;
            } else {
                if (cmd == 0) {
                    continue;
                }

                moveStep(pos, direc, cmd);
                max = Math.max(max, pos.i * pos.i + pos.j * pos.j);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        new Solution().robotSim(new int[] {4,-1, 4, -2, 4}, new int[][] {{2,4}});
    }
}