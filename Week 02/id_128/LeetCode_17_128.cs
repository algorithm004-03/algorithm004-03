//dfs
public class Solution
{
    public IList<string> LetterCombinations(string digits)
    {
        var result = new List<string>();
        if (digits.Length == 0)
            return result;

        var map = new Dictionary<char, IList<char>>(10);

        map['2'] = new List<char>() { 'a', 'b', 'c' };
        map['3'] = new List<char>() { 'd', 'e', 'f' };
        map['4'] = new List<char>() { 'g', 'h', 'i' };
        map['5'] = new List<char>() { 'j', 'k', 'l' };
        map['6'] = new List<char>() { 'm', 'n', 'o' };
        map['7'] = new List<char>() { 'p', 'q', 'r', 's' };
        map['8'] = new List<char>() { 't', 'u', 'v' };
        map['9'] = new List<char>() { 'w', 'x', 'y', 'z' };


        Search(digits, map, 0, new char[digits.Length], result);
        return result;
    }

    private void Search(string digits, IDictionary<char, IList<char>> map, int index, char[] temp, IList<string> result)
    {

        if (index == digits.Count())
        {
            result.Add(new String(temp));
            return;
        }
        foreach (char letter in map[digits[index]])
        {
            temp[index] = letter;
            Search(digits, map, index + 1, temp, result);
        }
    }
}


//bfs
public class Solution
{
    public IList<string> LetterCombinations(string digits)
    {
        var result = new List<string>();
        if (digits.Length == 0)
            return result;

        var map = new Dictionary<char, IList<string>>(10);

        map['2'] = new List<string>() { "a", "b", "c" };
        map['3'] = new List<string>() { "d", "e", "f" };
        map['4'] = new List<string>() { "g", "h", "i" };
        map['5'] = new List<string>() { "j", "k", "l" };
        map['6'] = new List<string>() { "m", "n", "o" };
        map['7'] = new List<string>() { "p", "q", "r", "s" };
        map['8'] = new List<string>() { "t", "u", "v" };
        map['9'] = new List<string>() { "w", "x", "y", "z" };

        var queue = new Queue<string>();
        foreach (var letter in map[digits[0]])
        {
            queue.Enqueue(letter);
        }
        var idx = 1;
        while (queue.Count() > 0)
        {
            var size = queue.Count();
            while (size-- > 0)
            {
                var curString = queue.Dequeue();
                if (idx == digits.Length)
                {
                    result.Add(curString);
                    continue;
                }
                foreach (var letter in map[digits[idx]])
                {
                    queue.Enqueue(curString + letter);
                }
            }
            idx++;
        }
        return result;
    }
}