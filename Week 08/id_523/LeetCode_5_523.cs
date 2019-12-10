public class Solution
{
    public string LongestPalindrome(string s)
    {
        var result = string.Empty;
        for (int i = 0; i < s.Length; i++)
        {
            var left = i;
            var right = i;
            while (left >= 0 && right < s.Length)
            {
                if (s[left] == s[right])
                {
                    if (right - left + 1 > result.Length)
                    {
                        result = s.Substring(left, right - left + 1);
                    }

                    left--;
                    right++;
                }
                else
                {
                    break;
                }
            }

            left = i;
            right = i;
            if (right + 1 < s.Length && s[left] == s[right + 1])
            {
                right++;
                while (left >= 0 && right < s.Length)
                {
                    if (s[left] == s[right])
                    {
                        if (right - left + 1 > result.Length)
                        {
                            result = s.Substring(left, right - left + 1);
                        }

                        left--;
                        right++;
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }

        return result;
    }
}