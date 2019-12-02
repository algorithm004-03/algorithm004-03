import java.util.HashSet;
import java.util.Set;

public class LeetCode_874_368 {

    /*机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
            -2：向左转 90 度
            -1：向右转 90 度
            1 <= x <= 9：向前移动 x 个单位长度
            在网格上有一些格子被视为障碍物。
    第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
    如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
    返回从原点到机器人的最大欧式距离的平方。
    链接：https://leetcode-cn.com/problems/walking-robot-simulation*/

    public static void main(String[] args) {

    }

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "-" + obstacle[1]);
        }
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, dir = 0, max = 0;
        for (int command : commands) {
            if (command == -2) {
                dir = dir == 0 ? 3 : dir - 1;
            } else if (command == -1) {
                dir = dir == 3 ? 0 : dir + 1;
            } else {
                while (command-- > 0 && !set.contains((x + dirs[dir][0]) + "-" + (y + dirs[dir][1]))) {
                    x += dirs[dir][0];
                    y += dirs[dir][1];
                }
            }
            max = Math.max(max, x * x + y * y);
        }
        return max;
    }
}
