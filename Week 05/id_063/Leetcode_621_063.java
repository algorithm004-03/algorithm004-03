/*

思路
把每n+1次选择想象成一轮，当前一轮选择肯定是每种任务选一个，如果任务种类数不够，就
用气泡填充，直到有一轮选择中途导致所有任务选择完，这一轮就是结束的一轮，且步数是最少
的，所以每次应该选剩余量最多的任务，够n种就选n个，否则填气泡，除了最后一轮外，
每一轮产生n+1步数开销是不可能节省的


 */

import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        TreeMap<Integer, Integer> cnt  = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });       // key 为剩余数量，value为剩余该数量的任务种数

        int[] cntArr = new int[26];

        for (char ch : tasks) {
            cntArr[ch-'A']++;
        }

        for (int i : cntArr) {
            if (i != 0) {
                cnt.putIfAbsent(i, 0);
                cnt.put(i, cnt.get(i) + 1);
            }
        }

        int step = 0;
        while (true) {
            Map<Integer, Integer> tmp = new HashMap<>();
            // 循环完成一轮选择
            int chooseCnt = n+1;
            for (int taskNum : cnt.keySet()) {
                if (cnt.get(taskNum) >= chooseCnt) {
                    cnt.put(taskNum, cnt.get(taskNum) - chooseCnt);
                    if (taskNum > 1) {
                        tmp.put(taskNum - 1, chooseCnt);
                    }
                    chooseCnt = 0;
                } else {
                    chooseCnt -= cnt.get(taskNum);
                    if (taskNum > 1) {
                        tmp.put(taskNum - 1, cnt.get(taskNum));
                    }

                    cnt.put(taskNum, 0);
                }

                if (chooseCnt == 0) {
                    break;
                }
            }

            for (int taskNum : tmp.keySet()) {
                cnt.putIfAbsent(taskNum, 0);
                cnt.put(taskNum, cnt.get(taskNum) + tmp.get(taskNum));
            }

            List<Integer> zeroList = new ArrayList<>();
            for (int taskNum : cnt.keySet()) {
                if (cnt.get(taskNum) == 0) {
                    zeroList.add(taskNum);
                }
            }

            for (int taskNum : zeroList) {
                cnt.remove(taskNum);
            }

            if (!cnt.isEmpty()) {
                step += (n+1);
            } else {
                step += ((n+1) - chooseCnt);
                break;
            }
        }

        return step;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().leastInterval(new char[] {'A','A','A','B','B','B'}, 0));
    }
}