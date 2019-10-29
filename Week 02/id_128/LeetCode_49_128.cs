
//categorize str by chararacter occurence count
//Time complexity O(nm)
public class Solution
{
    public IList<IList<string>> GroupAnagrams(string[] strs)
    {
        var map = new Dictionary<string, IList<string>>(strs.Length);
        foreach (var str in strs)
        {
            var key = GetKey(str);
            if (!map.ContainsKey(key))
            {
                map[key] = new List<string>();
            }
            map[key].Add(str);
        }

        return map.Values.ToList();
    }

    private string GetKey(string str)
    {
        int[] temp = new int[26];
        foreach (var c in str)
        {
            temp[c - 'a']++;
        }

        var sb = new StringBuilder();
        for (int i = 0; i < 26; i++)
        {
            if (temp[i] > 0)
            {
                sb.Append((char)i);
                sb.Append(temp[i]);
            }
        }
        return sb.ToString();
    }
}