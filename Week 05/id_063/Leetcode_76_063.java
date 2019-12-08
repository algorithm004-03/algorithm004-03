/*

思路
用i j 两个位置枚举区间的上界和下界，只有刚好满足字符计数要求的
区间才有可能是最短的，所以在能够满足计数要求情况下，尽量将左边界
右移，移动不了时候，扩展右边界，如果扩展右边界能够增加当前左边界位置
的字符的数量，左边界就有机会右移，这样两个边界一直更新，直到左右边界都
不能动为止，中间所有出现的符合计数要求的区间中长度最小值就是最终
的答案，时间复杂度是线性的，比起枚举所有的子区间要快很多，因为
计算过程中利用了当前区间的字符计数信息，避免了大量的重复统计计算

 */


import java.util.HashMap;
import java.util.Map;

class Solution {

    // 判定当前持有的字符数量是否充足
    private boolean isCharEnough(Map<Character, Integer> a, Map<Character, Integer> b) {
        for (char ch : b.keySet()) {
            if (!a.containsKey(ch)) {
                return false;
            }

            if (a.get(ch) < b.get(ch)) {
                return false;
            }
        }

        return true;
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> chrCnt = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            chrCnt.putIfAbsent(t.charAt(i), 0);
            chrCnt.put(t.charAt(i), chrCnt.get(t.charAt(i)) + 1);
        }

        Map<Character, Integer> state = new HashMap<>();
        int rightEnd = -1;
        for (int i = 0; i < s.length(); i++) {
            if (!chrCnt.containsKey(s.charAt(i))) {
                continue;
            }

            state.putIfAbsent(s.charAt(i), 0);
            state.put(s.charAt(i), state.get(s.charAt(i)) + 1);

            if (isCharEnough(state, chrCnt)) {
                rightEnd = i;
                break;
            }
        }

        if (rightEnd == -1) {
            return "";
        }

        int i = 0, j = rightEnd;
        int minLen = (j-i+1);
        int result_i = i, result_j = j;
        while (true) {
            // 移动左边界
            while (true) {
                char ch = s.charAt(i);
                if (!chrCnt.containsKey(ch)) {
                    i++;
                } else if (state.get(ch) > chrCnt.get(ch)) {
                    i++;
                    state.put(ch, state.get(ch) - 1);
                } else {
                    break;
                }
            }

            if ((j - i + 1) < minLen) {
                result_i = i; result_j = j; minLen = (j - i +1);
            }

            // 移动右边界
            while(true) {
                if (j+1 == s.length()) {
                    j = s.length();
                    break;
                }

                char ch = s.charAt(j+1);
                if (!chrCnt.containsKey(ch)) {
                    j++;
                    continue;
                } else {
                    j++;
                    state.put(ch, state.get(ch) + 1);
                    if (ch == s.charAt(i)) {
                        // 只有增加了左边界所在的字符的数量，左边界才可能右移
                        break;
                    }
                }
            }

            if (j == s.length()) {
                break;
            }
        }

        return s.substring(result_i, result_j + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}
