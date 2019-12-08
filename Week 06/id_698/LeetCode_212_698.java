/**
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 
 * @author gning (id=698)
 */

 public class LeetCode_212_698 {

    class TrieNode {

        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        private String s;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setString(String str) {
            s = str;
        }

        public String getSTring() {
            return s;
        }

    }

    class Trie {
        private TrieNode root;

        /** Initialize your data structure here. */
        public  Trie() {
            root = new TrieNode();
        }

        public TrieNode getRoot() {
            return root;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;

            for(int i=0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if(!node.containsKey(currentChar)) {
                    node.put(currentChar, new TrieNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd();
            node.setString(word);
        }

        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for(int i=0; i < word.length(); i++) {
                char currentChar = word.charAt(i);

                if(node.containsKey(currentChar)) {
                    node = node.get(currentChar);
                }else{
                    return null;
                }
            }  

            return node;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            
            return node != null && node.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);

            return node != null;
        }
        
    }

    public List<String> findWords(char[][] board, String[] words) {

        Trie trie = new Trie();
        TrieNode root = trie.getRoot();

        for (String s: words) {
            trie.insert(s);
        }

        Set<String> result = new HashSet<>();

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];        

        for(int i=0; i < m; i++ ) {
            for (int j=0; j < n; j++ ) {
                find(board,visited,i,j,m,n,result,root); 
            }
        }

        return new LinkedList<String>(result);
    }

    private void find(char[][] board, boolean[][] visited, int i, int j, int m, int n, Set<String> result, TrieNode node) {
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j]) {
            return; 
        }

        node = node.get(board[i][j]);

        visited[i][j] = true;

        if(node == null) {
            visited[i][j] = false;
            return;
        }

        if(node.isEnd()) {
            result.add(node.getSTring());
        }

        find(board,visited,i+1,j,m,n,result,node);
        find(board,visited,i,j+1,m,n,result,node);
        find(board,visited,i,j-1,m,n,result,node);
        find(board,visited,i-1,j,m,n,result,node);

        visited[i][j] = false;

    }
 }