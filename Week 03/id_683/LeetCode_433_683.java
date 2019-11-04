import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {

    public int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || bank == null) {
            return -1;
        }
        if (start.equals(end)) {
            return 0;
        }
        int times = 0;
        char[] mutations = new char[] {'T', 'G', 'A', 'C'};
        Set<String> bankSet = new HashSet<>();
        for (int i = 0; i < bank.length; ++i) {
            bankSet.add(bank[i]);
        }
        Set<String> visited = new HashSet<>();
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String cur = queue.poll();
                if (end.equals(cur)) {
                    return times;
                }
                char[] curChars = cur.toCharArray();
                for (int i = 0; i < curChars.length; ++i) {
                    char old = curChars[i];
                    for (char mutation : mutations) {
                        curChars[i] = mutation;
                        String next = new String(curChars);
                        if (bankSet.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    curChars[i] = old;
                }
                size--;
            }
            times++;
        }
        return -1;
    }
}