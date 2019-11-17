class Solution{
    	public int ladderLength (String beginWord, String endWord, List<String> wordList) {
            if(wordList.contains(endWord) == false) return 0;
		    Queue<String> q = new LinkedList<>();
            HashSet<String> dic = new HashSet<>(wordList);
            HashSet<String> visited = new HashSet<>();
            visited.add(beginWord);
            q.add(beginWord);
            int count =1;
            while(q.isEmpty() == false){
                int size = q.size();
                for(int i=0;i<size;i++){
                    String words= q.poll();
                    for(int k=0;k<words.length();k++){
                         char[] letter=words.toCharArray();
                        for(char ch='a';ch<='z';ch++){
                        letter[k]=ch;
                        String word = new String(letter);
                        if(word.equals(endWord)) return count+1;
                        if(dic.contains(word) && !visited.contains(word)){
                            q.add(word);
                            visited.add(word);
                        }
                     }
                  }
                }
                count++;
            }
            return 0;
	}
}
