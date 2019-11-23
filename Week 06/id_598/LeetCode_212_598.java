import java.util.*;

/**
 * @author northleaf
 * @create 2019年11月19日
 */
public class LeetCode_212_598 {
    public List<String> findWords(char[][] board, String[] words) {

        List<String> ans = new ArrayList<String>();

        //构造字典树
        WordTrie wordTrie = new WordTrie();
        for(int i = 0;i<words.length;i++){
            wordTrie.insertWord(words[i]);
        }

        //二维数组遍历
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        //字义一个结果数组
        Set<String> set = new HashSet<String>();
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                find(i,j,m,n,board,visited,set,wordTrie.root);
            }
        }

        return new ArrayList<String>(set);

    }

    private void find(int i, int j, int m, int n, char[][] board, boolean[][] visited, Set<String> set, TrieNode cur) {
        //终止条件
        // i,j的值不能出数组的边界
        if(i<0 || j < 0 || i>=m||j >=n || visited[i][j] ){
            return;
        }
        //查找字符
        cur = cur.get(board[i][j]);
        visited[i][j] =true;
        //是否存在
        if (cur == null) {
            //不存在，标记为未访问过
            visited[i][j] = false;
            return;
        }
        //是否找到了单词
        if(cur.isEnd){
            set.add(cur.var);
        }
        //四通路遍历
        find(i+1,j,m,n,board,visited,set,cur);
        find(i-1,j,m,n,board,visited,set,cur);
        find(i,j+1,m,n,board,visited,set,cur);
        find(i,j-1,m,n,board,visited,set,cur);
        //将访问标记重置，下个节点可能会用到
        visited[i][j] =false;
    }

    /**
     * 字典树
     */
    class WordTrie{
        TrieNode root ;

        public WordTrie(){
            this.root = new TrieNode();
        }

        public void insertWord(String word){
            TrieNode node = root;
            for(int i = 0;i<word.length();i++){
                char ch = word.charAt(i);
                if(!node.contains(ch)){
                    node.put(ch,new TrieNode());
                }
                node = node.get(ch);
            }
            node.setEnd(word);
        }
    }


    /**
     * 字典树节点
     */
    class TrieNode{
        TrieNode[] nodes ;
        //是否结尾
        boolean isEnd = false;

        String var ;

        public TrieNode() {
            nodes = new TrieNode[26];
        }

        public boolean contains(char c){
            return nodes[c - 'a'] != null;
        }

        public TrieNode get(char ch){
            return nodes[ch - 'a'];
        }

        public void put(char ch ,TrieNode trieNode){
            nodes[ch - 'a'] = trieNode;
        }

        public void setEnd(String var){
            isEnd = true;
            this.var = var;
        }

    }
}
