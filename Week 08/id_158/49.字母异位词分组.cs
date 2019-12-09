/*
 * @lc app=leetcode.cn id=49 lang=csharp
 *
 * [49] 字母异位词分组
 */

// @lc code=start
public class Solution {
    public IList<IList<string>> GroupAnagrams(string[] strs)
    {
        int len = strs.Length;
        IList<IList<string>> result = new List<IList<string>>();
        Dictionary<string, List<string>> map = new Dictionary<string, List<string>>();
        foreach (var str in strs)
        {
            char[] arrStr = str.ToCharArray();
            Array.Sort(arrStr);
            string strSort = new string(arrStr);
            if (map.ContainsKey(strSort))
            {
                map[strSort].Add(str);
            }
            else
            {
                map.Add(strSort, new List<string> { str });
            }
        }
        foreach (var item in map)
        {
            result.Add(item.Value);
        }
        return result;
    }

    public IList<IList<string>> GroupAnagrams(string[] strs)
    {
        int len = strs.Length;
        IList<IList<string>> result = new List<IList<string>>();
        Dictionary<string, List<string>> map = new Dictionary<string, List<string>>();
        foreach (var str in strs)
        {
            char[] arrStr = str.ToCharArray();
            Array.Sort(arrStr);
            string strSort = new string(arrStr);
            if (!map.ContainsKey(strSort))
            {
                map.Add(strSort, new List<string>());
                
            }
            map[strSort].Add(str);
        }
        foreach (var item in map)
        {
            result.Add(item.Value);
        }
        return result;
    }
}
// @lc code=end

