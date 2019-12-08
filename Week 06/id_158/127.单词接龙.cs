/*
 * @lc app=leetcode.cn id=127 lang=csharp
 *
 * [127] 单词接龙
 */

// @lc code=start
using System.Collections.Generic;

public class Solution
{
    public int LadderLength(string beginWord, string endWord, IList<string> wordList)
    {
        if (!wordList.Contains(endWord))
            return 0;
        int n = beginWord.Length;
        Dictionary<string, IList<string>> allCommons = new Dictionary<string, IList<string>>();
        foreach (var word in wordList)
        {
            for (int i = 0; i < n; i++)
            {
                string common = word.Substring(0, i) + "*" + word.Substring(i + 1);
                if (!allCommons.ContainsKey(common))
                    allCommons.Add(common, new List<string>());
                allCommons[common].Add(word);
            }
        }
        IList<string> begin = new List<string>();
        IList<string> end = new List<string>();
        begin.Add(beginWord);
        end.Add(endWord);

        IList<string> visited = new List<string>();
        int len = 1;
        while (begin.Count > 0 && end.Count > 0)
        {
            if (begin.Count > end.Count)
            {
                IList<string> tmp = begin;
                begin = end;
                end = tmp;
            }
            IList<string> neighbor = new List<string>();
            foreach (string cur in begin)
            {
                for (int i = 0; i < n; i++)
                {
                    string tmp = cur.Substring(0, i) + "*" + cur.Substring(i + 1);
                    if (!allCommons.ContainsKey(tmp))
                        continue;
                    foreach (string str in allCommons[tmp])
                    {
                        if (end.Contains(str))
                            return len + 1;
                        if (!visited.Contains(str))
                        {
                            visited.Add(str);
                            neighbor.Add(str);
                        }
                    }
                }
            }
            begin = neighbor;
            len++;
        }
        return 0;
    }
}
// @lc code=end

