/*
从左到右类似滑动窗口一样更新每一个字符的频率统计值即可
 */


class Solution {

    private boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();

        if (s.length() < p.length()) {
            return ret;
        }

        int[] target = new int[26];
        int[] cur = new int[26];
        for (char ch : p.toCharArray()) {
            target[ch-'a']++;
        }

        int l = 0, r = p.length() - 1;
        for (int i = 0; i < p.length(); i++) {
            cur[s.charAt(i)-'a']++;
        }

        while (r < s.length()) {
            if (isSame(cur, target)) {
                ret.add(l);
            }

            cur[s.charAt(l)-'a']--;
            if (r+1 < s.length()) {
                cur[s.charAt(r+1)-'a']++;
            }
            l++; r++;
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("abab", "ab"));
    }
}