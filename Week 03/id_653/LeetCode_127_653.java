import javafx.util.Pair;

public class Solution {
    HashMap wildMap = new HashMap();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                String wildWord = word.substring(0, i) + "*" + word.substring(i + 1, L);
                List list = (List) wildMap.getOrDefault(wildWord,new ArrayList<>());
                list.add(word);
                wildMap.put(wildWord, list);
            }
        }
        Queue<Pair<String,Integer>> queue = new LinkedList();

        Pair<String,Integer> root = new Pair(beginWord, 1);
        queue.add(root);

        HashMap visitedMap = new HashMap();
        visitedMap.put(beginWord,0);
        while (!queue.isEmpty()) {
            Pair<String,Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < L; i++) {
                String wildWord = word.substring(0, i) + "*" + word.substring(i + 1, L);
                List <String>list = (List) wildMap.getOrDefault(wildWord,new ArrayList<>());
                for(String nextWord:list) {
                    if (nextWord.equals(endWord)) {
                        return level+1;
                    }

                    if (!visitedMap.containsKey(nextWord)) {
                        queue.add(new Pair<>(nextWord,level+1));
                        visitedMap.put(nextWord,0);
                    }
                }
            }


        }

        return 0;
    }
}