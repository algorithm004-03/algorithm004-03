package id_693;

import java.util.*;

/**
 * @Author 李雷（KyLin）
 * @Desc 1244. 力扣排行榜	https://leetcode-cn.com/problems/design-a-leaderboard/
 * @Date 2019/11/27
 */
public class LeetCode_1244_693 {
    /**
     * HashMap
     */
    class Leaderboard {
        Map<Integer, Integer> map;

        public Leaderboard() {
            map = new HashMap<>();
        }

        public void addScore(int playerId,int score) {
            map.put(playerId,map.getOrDefault(playerId,0) + score);
        }

        public int top(int K) {
            List<Integer> list = new ArrayList<>(map.values());
            Collections.sort(list);
            int res = 0;
            int size = list.size();
            for (int i = size - K; i < size; i++) {
                res += list.get(i);
            }
            return res;
        }

        public void reset(int playerId) {
            map.remove(playerId);
        }
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */