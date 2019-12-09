/*

简单数据结构时间
两个Map实现
 */


import java.util.*;

class Leaderboard {
    private Map<Integer, Integer> id2score;
    private Map<Integer, Integer> score2cnt;

    public Leaderboard() {
        id2score = new HashMap<>();
        score2cnt = new TreeMap<>((a, b) -> (b - a));
    }

    public void addScore(int playerId, int score) {
        if (id2score.containsKey(playerId)) {
            int oldScore = id2score.get(playerId);

            score2cnt.put(oldScore, score2cnt.get(oldScore) - 1);
            score2cnt.putIfAbsent(oldScore + score, 0);
            score2cnt.put(oldScore + score, score2cnt.get(oldScore + score) + 1);

            id2score.put(playerId, oldScore + score);
        } else {
            score2cnt.putIfAbsent(score, 0);
            score2cnt.put(score, score2cnt.get(score) + 1);

            id2score.put(playerId, score);
        }
    }

    public int top(int K) {
        int sum = 0;
        int cnt = K;
        for (Map.Entry<Integer, Integer> entry : score2cnt.entrySet()) {
            if (cnt >= entry.getValue()) {
                sum += entry.getKey() * entry.getValue();
                cnt -= entry.getValue();
            } else {
                sum += entry.getKey() * cnt;
                break;
            }
        }

        return sum;
    }

    public void reset(int playerId) {
        addScore(playerId, -id2score.get(playerId));
    }
}