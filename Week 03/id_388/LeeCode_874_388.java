package com.company.leetcode.editor.cn;
//机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
//
//
// -2：向左转 90 度
// -1：向右转 90 度
// 1 <= x <= 9：向前移动 x 个单位长度
//
//
// 在网格上有一些格子被视为障碍物。
//
// 第 i 个障碍物位于网格点 (obstacles[i][0], obstacles[i][1])
//
// 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
//
// 返回从原点到机器人的最大欧式距离的平方。
//
//
//
// 示例 1：
//
// 输入: commands = [4,-1,3], obstacles = []
//输出: 25
//解释: 机器人将会到达 (3, 4)
//
//
// 示例 2：
//
// 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出: 65
//解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
//
//
//
//
// 提示：
//
//
// 0 <= commands.length <= 10000
// 0 <= obstacles.length <= 10000
// -30000 <= obstacle[i][0] <= 30000
// -30000 <= obstacle[i][1] <= 30000
// 答案保证小于 2 ^ 31
//
// Related Topics 贪心算法


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_874 {
    public int robotSim(int[] commands, int[][] obstacles) {

        //方向处理
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};
        int di = 0;//0-上 1-右 2-下 3-左
        Set<String> obstacleSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            int x = obstacles[i][0];
            int y = obstacles[i][1];
            obstacleSet.add(x + "#" + y);
        }
        int ans = 0;
        int currentX = 0;
        int currentY = 0;
        for (int cmd:
                commands) {
            if (cmd == -2) {
                di = (di + 3) % 4;
                continue;
            }
            if (cmd == -1) {
                di = (di + 1) % 4;
                continue;
            }

            //移动 cmd 个单位
            for (int i = 0; i < cmd; i++) {
                int xn = currentX + dx[di];
                int yn = currentY + dy[di];
                if (!obstacleSet.contains(xn + "#" + yn)) {
                    currentX = xn;
                    currentY = yn;
                    ans = Math.max(ans,xn * xn + yn * yn);
                }
            }

        }

        return ans;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[] commands = new int[]{4,-1,4,-2,4};
//        int[] o = new int[]{2,4};
//        int[][] obstacles = new int[][]{o};
//        int ans = s.robotSim(commands,obstacles);
//        System.out.println(ans);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
