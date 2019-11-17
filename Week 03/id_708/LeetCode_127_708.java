class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 1;
        Set<String> visited = new HashSet<>();
        Set<String> dictSet = new HashSet<>(wordList);
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) { // 因为我们是按层级遍历，所以是多条路径并行查找，当找到最小路径时，直接返回
                String curr = queue.poll();
                if (curr.equals(endWord)) return level;
                char[] currChars = curr.toCharArray();
                for (int i = 0; i < currChars.length; i++) {
                    char old = currChars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        currChars[i] = j;
                        String word = new String(currChars);
                        if (!visited.contains(word) && dictSet.contains(word)) {
                            queue.offer(word);
                            visited.add(word);
                        }
                    }
                    currChars[i] = old;
                }
            }
            level++;
        }
        return 0;
    }
}