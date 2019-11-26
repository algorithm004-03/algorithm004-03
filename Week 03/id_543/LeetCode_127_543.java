class Solution {

    //单向BFS 提交超时
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> levelvisitSet = new HashSet<String>();
        int length = 1;
        levelvisitSet.add(beginWord);
        while (!levelvisitSet.contains(endWord)){
            Set<String> temSet = new HashSet<String>();
            for(String word:levelvisitSet){
                for (int i = 0;i <word.length(); i++)
                    for(char ch = 'a';ch <= 'z';ch++){
                        char[] wordChar = word.toCharArray();
                        wordChar[i] = ch;
                        String levelword = new String(wordChar);
                        if(wordList.contains(levelword)){
                            temSet.add(levelword);
                            wordList.remove(levelword);
                        }
                    }
            }
            if(temSet.isEmpty()){
                return 0;
            }
            levelvisitSet=temSet;
            length++;
        }
        return length;
    }



    //将list转化为set  set是基于hashMap，remove、contain是的时间复杂度是O(1)   List是基于数据或链表 remove、contains都是O(n)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> levelvisitSet = new HashSet<String>();
        Set<String> wordSet = new HashSet<String>(wordList);
        int length = 1;
        levelvisitSet.add(beginWord);
        while (!levelvisitSet.contains(endWord)){
            Set<String> temSet = new HashSet<String>();
            for(String word:levelvisitSet){
                for (int i = 0;i <word.length(); i++)
                    for(char ch = 'a';ch <= 'z';ch++){
                        char[] wordChar = word.toCharArray();
                        wordChar[i] = ch;
                        String levelword = new String(wordChar);
                        if(wordSet.contains(levelword)){
                            temSet.add(levelword);
                            wordSet.remove(levelword);
                        }
                    }
            }
            if(temSet.isEmpty()){
                return 0;
            }
            levelvisitSet=temSet;
            length++;
        }
        return length;
    }

    //双向BFS 还在学习中

}