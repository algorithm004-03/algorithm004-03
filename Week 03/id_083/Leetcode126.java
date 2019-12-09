/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start
import javafx.util.*;
import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> ans = new ArrayList<>();
        if(!wordList.contains(endWord)){
            return ans;
        }
        bfs(beginWord,endWord,wordList,ans);
        return ans;
    }

    public void bfs(String beginWord,String endWord,List<String>wordList,List<List<String>>ans){
        Queue<List<String>> queue = new LinkedList();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        queue.offer(path);
        boolean isFound = false;
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while(!queue.isEmpty()){
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for(int j=0;j<size;j++){
                List<String> p = queue.poll();
                String temp = p.get(p.size() -1);//得到当前路径的末尾单词
                ArrayList<String> neighbors = getNeighbors(temp,dict);
                for(String neighbor:neighbors) {
                    if(!visited.contains(neighbor)){//只对没访问过的单词
                        if(neighbor.equals(endWord)){//到达词尾
                            isFound = true;
                            p.add(neighbor);
                            ans.add(new ArrayList<String>(p));
                            p.remove(p.size() - 1);
                        }
                        p.add(neighbor);//加入当前单词
                        queue.offer(new ArrayList<String>(p));
                        p.remove(p.size()-1);
                        subVisited.add(neighbor);
                    }
                }
            }
            visited.addAll(subVisited);
            if(isFound){
                break;
            }
        }
    }

    private ArrayList<String> getNeighbors(String node,Set<String>dict){
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();
        for(char ch ='a';ch<='z';ch++ ){
            for(int i=0;i<chs.length;i++){
                if(chs[i] == ch)
                continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if(dict.contains(String.valueOf(chs))){
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }
        } return res;
    }
}
// @lc code=end

