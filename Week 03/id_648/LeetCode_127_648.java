import javafx.util.Pair;

import java.util.*;

/**
 * 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 *
 */
public class LeetCode_127_648 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,List<String>> allComboDict = new HashMap<>();
        int L = beginWord.length();
        wordList.forEach(word ->{
            for(int i=0; i<L;i++){
                String newWord = word.substring(0,i)+"*"+word.substring(i+1,L);
                List<String> list = allComboDict.getOrDefault(newWord,new ArrayList<>());
                list.add(word);
                allComboDict.put(newWord,list);
            }
        });
        HashMap<String,Boolean> visted = new HashMap<>();
        visted.put(beginWord,true);
        Queue<Pair<String,Integer>> q = new LinkedList<>();
        q.add(new Pair<String,Integer>(beginWord,1));
        while(!q.isEmpty()){
            Pair<String,Integer> node = q.remove();
            String word =node.getKey();
            Integer level = node.getValue();
            for(int i=0;i<L;i++){
                String newWord = word.substring(0,i)+"*"+word.substring(i+1,L);
                for(String advancedWord:allComboDict.getOrDefault(newWord,new ArrayList<>())){
                    System.out.println("advancedWord:"+advancedWord+" advancedWord:"+endWord);
                    if(advancedWord.equals(endWord)){
                        return level+1;
                    }
                    if(!visted.containsKey(advancedWord)){
                        visted.put(advancedWord,true);
                        q.add(new Pair<String,Integer>(advancedWord,level+1));
                    }

                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode_127_648 leetCode_127_648 = new LeetCode_127_648();
        String[] wordList = new String[]{"hot","dot","dog","lot","log","cog"};
        String beginWord = "hit", endWord = "cog";
        int num =leetCode_127_648.ladderLength(beginWord,endWord,Arrays.asList(wordList));
        System.out.println(num);
    }

}


