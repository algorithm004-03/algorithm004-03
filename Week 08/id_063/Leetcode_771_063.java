
/*
简单字符串处理
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> s = new HashSet<>();

        for (char ch : J.toCharArray()) {
            s.add(ch);
        }

        int cnt = 0;
        for (char ch : S.toCharArray()) {
            if (s.contains(ch)) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numJewelsInStones("aA", "aAAbbbb"));
    }
}