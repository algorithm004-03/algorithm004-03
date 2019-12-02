/*
 * @lc app=leetcode.cn id=242 lang=csharp
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
public class Solution {
    ///暴力
    public bool IsAnagram(string s, string t) {
        char[] arrS=s.ToCharArray();
        char[] arrT = t.ToCharArray();
        Array.Sort(arrS);
        Array.Sort(arrT);
        return Enumerable.SequenceEqual(arrS, arrT);
    }
    /*
      计数器
     */
    public bool IsAnagram(string s, string t) {
            if (s.Length != t.Length) return false;
            int[] alphabet = new int[26];
            for (int i = 0; i < s.Length; i++)
                alphabet[s[i] - 'a']++;
            for (int i = 0; i < t.Length; i++)
                alphabet[t[i] - 'a']--;
            foreach (int i in alphabet)
                if (i != 0) return false;
            return true;
    }

}
// @lc code=end

