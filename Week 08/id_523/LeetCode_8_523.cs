public class Solution
{
    public int MyAtoi(string str)
    {
        if (string.IsNullOrWhiteSpace(str)) return 0;
        str = str.Trim(' ');

        bool isNagetive = str[0] == '-';

        int result = 0;
        for (int i = (isNagetive || str[0] == '+') ? 1 : 0; i < str.Length; i++)
        {
            if (str[i] < 48 || str[i] > 57) break;

            var val = str[i] - 48;

            if (!isNagetive && (result > int.MaxValue / 10 || (int.MaxValue - result * 10 - val) < 0))
            {
                return int.MaxValue;
            }

            if (isNagetive && (0 - result < int.MinValue / 10 || (int.MinValue + result * 10 + val) > 0))
            {
                return int.MinValue;
            }

            result = result * 10 + val;
        }

        return isNagetive ? 0 - result : result;
    }
}