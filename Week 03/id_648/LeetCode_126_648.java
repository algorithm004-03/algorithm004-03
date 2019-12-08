import javafx.util.Pair;

import java.util.*;

/**
 * 单词接龙 II
 */
public class LeetCode_126_648 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,Integer> distance = new HashMap<>();
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        bfs(beginWord,endWord,wordList,map,distance);
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(beginWord);
        findLaddersHelper(beginWord,endWord,map,distance,temp,ans);
        return ans;
    }
    private void findLaddersHelper(String beginWord,String endWord,HashMap<String,ArrayList<String>> map,HashMap<String,Integer> distance,ArrayList<String> temp,List<List<String>> ans){
        if(beginWord.equals(endWord)){
            ans.add(new ArrayList<String>(temp));
            return;
        }
        ArrayList<String> wordNeighbors = map.getOrDefault(beginWord,new ArrayList<>());
        for(String neighbor:wordNeighbors){
            if(distance.get(beginWord)+1 ==distance.get(neighbor)){
                temp.add(neighbor);
                findLaddersHelper(neighbor,endWord,map,distance,temp,ans);
                temp.remove(temp.size()-1);
            }
        }

    }

    private void bfs(String beginWord, String endWord, List<String> wordList,HashMap<String,ArrayList<String>> map,HashMap<String,Integer> distance){
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord,0);
        boolean isFound =false;
        HashSet<String> set = new HashSet<>(wordList);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i=0;i<size;i++){
                String qword = queue.poll();
                ArrayList<String> wordNeighbors = getNeighbors(qword,set);
                map.put(qword,wordNeighbors);
                for(String neighbor:wordNeighbors){
                    if(!distance.containsKey(neighbor)){
                        distance.put(neighbor,depth);
                        if(neighbor.equals(endWord)){
                            isFound=true;
                        }
                        queue.offer(neighbor);
                    }
                }
            }
            if(isFound){break;}
        }

    }
    private ArrayList<String> getNeighbors(String word,HashSet<String> dict){
        ArrayList<String> res = new ArrayList<String>();
        char[] chars = word.toCharArray();
        for(char ch='a';ch<'z';ch++){
            for(int i=0;i<chars.length;i++){
                if(chars[i]==ch){continue;}
                char old_char = chars[i];
                chars[i] = ch;
                if(dict.contains(String.valueOf(chars))){
                    res.add(String.valueOf(chars));
                }
                chars[i] = old_char;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_126_648 leetCode_126_648 = new LeetCode_126_648();
        String[] wordList = new String[]{"hot","dot","dog","lot","log","cog"};
        String beginWord = "hit", endWord = "cog";
        List<List<String>> ans  =leetCode_126_648.findLadders(beginWord,endWord,Arrays.asList(wordList));
        ans.forEach(list ->{
            System.out.println(list);
        });
    }
}
