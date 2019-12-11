/*
思路：
用Hash保存每一个字符出现的频次，遍历s中所有字符统计字符频次，然后遍历t中所有字符
将hash中对应字符的频次进行递减，t中出现任何不在hash中的字符或者有任何一个字符频次
减少到0以下，都说明t和s不匹配，可以立即判断失败，不必在最后去统计是不是所有字符的频次
都减到0

自己用数组实现Hash比起用库里面的hash表要快一些
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] cnt = new int[256];
        
        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            cnt[(int)ch]++;
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            cnt[(int)ch]--;

            if (cnt[(int)ch] < 0) {
                return false;
            }
        }

        return true;
    }
}