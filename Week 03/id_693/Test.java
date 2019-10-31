package id_693;

import java.util.*;

/**
 * @Desc
 * @Auther 李雷(KyLin)
 * @Date 2019/10/30
 */
public class Test {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> banks = new HashSet<String>();
        for (String s : bank) {
            banks.add(s);
        }
        if (start.equals(end) && banks.contains(end)) {
            return 1;
        }
        if (!banks.contains(end)) {
            return 0;
        }
        Set<String> st = new HashSet<String>();
        st.add(start);
        Set<String> en = new HashSet<String>();
        en.add(end);
        return dfs(st, en, banks, 2);
    }

    private int dfs(Set<String> start, Set<String> end, Set<String> banks, int depth) {
        if (start.size() == 0) {
            return depth;
        }
        if (start.size() > end.size()) {
            dfs(end, start, banks, depth);
        }
        banks.removeAll(start);
        while (!end.isEmpty()) {
            Set<String> toAdd = new HashSet<>();
            for (String each : start) {
                char[] chars = each.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char temp = chars[i];
                    for (char j = 'a'; j < 'z'; j++) {
                        chars[i] = j;
                        String word = new String(chars);
                        if (banks.contains(each)) {
                            if (end.contains(word)) return depth;
                            else toAdd.add(word);
                        }
                    }
                    chars[i] = temp;
                }
            }
            if (toAdd.size() == 0) {
                return depth;
            }
            end = toAdd;
        }
        return depth;

    }

}
