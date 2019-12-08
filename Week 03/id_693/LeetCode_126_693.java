package id_693;

import java.util.*;

/**
 * @Author 李雷（KyLin）
 * @Desc 126. 单词接龙 II    https://leetcode-cn.com/problems/word-ladder-ii/
 * @Date 2019/10/31
 */
public class LeetCode_126_693 {
    //BFS构造map图，然后dfs获取结果
    public List<List<String>> findLadders(String beginWord,String endWord,List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return result;
        }
        Set<String> start = new HashSet<>();
        start.add(beginWord);
        words.remove(beginWord);
        Set<String> end = new HashSet<>();
        end.add(endWord);

        Map<String, List<String>> mapTree = new HashMap<>();
        if (findBuildTree(mapTree,start,end,words,true)) {
            dfs(result,mapTree,beginWord,endWord,new LinkedList<>());
        }
        return result;
    }


    private boolean findBuildTree(Map<String, List<String>> mapTree,Set<String> start,Set<String> end,Set<String> words,boolean isFront) {
        if (start.size() == 0) {
            return false;
        }
        if (start.size() > end.size()) {
            return  findBuildTree(mapTree,end,start,words,!isFront);
        }
        words.removeAll(start);
        boolean isOk = false;
        Set<String> nextSet = new HashSet<>();
        for (String each : start) {
            char[] chars = each.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char j = 0; j <= 'z'; j++) {
                    chars[i] = j;
                    String word = String.valueOf(chars);
                    if (words.contains(word)) {
                        nextSet.add(word);
                        String key = isFront ? each : word;
                        String value = !isFront ? each : word;
                        if (!mapTree.containsKey(key)) {
                            mapTree.put(key,new ArrayList<>());
                        }
                        mapTree.get(key).add(value);
                        if (end.contains(word)) {
                            isOk = true;
                        }
                    }
                }
                chars[i] = temp;
            }
        }
        if (isOk) {
            return true;
        }
        return findBuildTree(mapTree,nextSet,end,words,isFront);
    }

    private void dfs(List<List<String>> result,Map<String, List<String>> mapTree,String beginWord,String endWord,LinkedList<String> temp) {
        temp.add(beginWord);
        if (endWord.equals(beginWord)) {
            result.add(new ArrayList<>(temp));
        }
        if (!mapTree.containsKey(beginWord)) {
            temp.removeLast();
            return;
        }
        List<String> next = mapTree.get(beginWord);
        for (String str : next) {
            dfs(result,mapTree,str,endWord,temp);
        }
        temp.removeLast();
    }

    public static void main(String[] args) {
        String ss = "/home/zcloud/db/masterdb_glass/masterdb_glass01";
        String ss2 = "/zcloud/";
        String ss3 = "/123/";
        String ss4 = "zcloud/";
        System.out.println(ss.substring(0,ss.indexOf("/zcloud")));
        System.out.println(ss2.substring(0,ss2.indexOf("zcloud")));
        System.out.println(ss3.substring(0,ss3.indexOf("zcloud")));
        System.out.println(ss4.substring(0,ss4.indexOf("zcloud")));
        //System.out.println(new LeetCode_126_693().findLadders("hit","cog",Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}