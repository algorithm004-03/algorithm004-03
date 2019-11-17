class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        char[] charArray = new char[]{ 'A', 'C', 'G', 'T' };
        Set<String> bankSet = new HashSet<>();
        for (String str : bank) bankSet.add(str);
        int level = 0;
        
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 这一轮循环里只改变了一个字符
            while (size-- > 0) {
                String curr = queue.poll();
                if (curr.equals(end)) return level;
                char[] chars = curr.toCharArray();
                // 每次循环都是针对其中一个字符的操作
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    // 对某个字符遍历所有可能
                    for (char c : charArray) {
                        chars[i] = c;
                        String str = new String(chars);
                        if (!visited.contains(str) && bankSet.contains(str)) {
                            queue.offer(str);
                            visited.add(str);
                        }
                    }
                    chars[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
}