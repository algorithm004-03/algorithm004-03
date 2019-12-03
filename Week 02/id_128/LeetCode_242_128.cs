//One loop, log occurences by ++ for string1 and by -- for string2. 
public class Solution1 {
    public bool IsAnagram(string s, string t) {
        
        if (s.Length != t.Length) {
            return false;
        }
        Dictionary<char, int> map = new Dictionary<char, int>(s.Length);
        
        for (int i = 0; i< s.Length;i++) {
            if (!map.ContainsKey(s[i])) {
                map[s[i]] = 0;
            }
            ++map[s[i]];
            
            if (!map.ContainsKey(t[i])) {
                map[t[i]] = 0;
            }
            --map[t[i]];
        }
        
        foreach (var value in map.Values) {
           if (value != 0) {
               return false;
           }
        }
        
        return true;
    }
}


//Loop string1 to build mapping, then loop string2
public class Solution2 {
    public bool IsAnagram(string s, string t) {
        
        if (s.Length != t.Length) {
            return false;
        }
        Dictionary<char, int> map = new Dictionary<char, int>(s.Length);
        
        foreach (var c in s) {
            if (!map.ContainsKey(c)) {
                map[c] = 0;
            }
            ++map[c];            
        }
        
        foreach (var c in t) {
            if (!map.ContainsKey(c)) {
                return false;
            }
            if (--map[c] <= 0) {
                map.Remove(c);
            }
        }
        
        return true;
    }
}
