class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Boolean> marked = new HashMap<>();
        Queue<String> queue = new LinkedList<String>();
        marked.put(beginWord, true);
        queue.add(beginWord);
        int len = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            len++;
            while(size-- > 0){
                String cur = queue.poll();
                for(String next: wordList){
                    if(marked.get(next) != null){
                        continue;
                    }
                    if(!canTransfer(cur, next)){
                        continue;
                    }
                    if(endWord.equals(next)){
                        return ++len;
                    }
                    queue.add(next);
                    marked.put(next, true);
                }
            }
        }
        
        return 0;
    }
    private boolean canTransfer(String s1, String s2){
        int index = 0;
        int cnt = 0;
        while(index < s1.length()){
            if(s1.charAt(index) != s2.charAt(index))
                cnt++;
            index++;
        }
        
        return cnt == 1;
    }
}
