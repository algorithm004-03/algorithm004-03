/*
两边扫描字符串
第一遍统计每一个字符出现的频数
第二遍从左到右找第一个频数是1的字符

 */


class Solution {
    public int firstUniqChar(String s) {
        int[] cnt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}