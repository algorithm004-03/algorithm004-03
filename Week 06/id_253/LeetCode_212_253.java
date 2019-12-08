
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        Trie myTrie = new Trie();
        TrieNode root = myTrie.root;
        boolean[][] visited = new boolean[m][n];
        Set<String> ans = new HashSet<>();
        for(int i =0 ; i<words.length ; i++){
            myTrie.insert(words[i]);
        }
        for(int i =0 ; i< m ;i++){
            for(int j = 0 ;j < n ; j++){
                find(board,words,i,j,m,n,visited,ans,root);
            }
        }
        return new LinkedList<String>(ans);
    }
    public void find(char[][] board , String[] words , int i , int j , int m , int n,boolean[][] visited , Set<String> ans,                             TrieNode cur){
        if(i < 0 || i >=m || j < 0 || j >= n || visited[i][j]) return ;
        cur=cur.child[board[i][j] - 'a'];
        visited[i][j] = true;
        if(cur == null ) {
            visited[i][j] = false;
            return;
        }
        if(cur.isEnd == true) ans.add(cur.val);
        find(board,words,i+1,j,m,n,visited,ans,cur);
        find(board,words,i,j+1,m,n,visited,ans,cur);
        find(board,words,i-1,j,m,n,visited,ans,cur);
        find(board,words,i,j-1,m,n,visited,ans,cur);
        visited[i][j] = false;
    }
}
class Trie{
    public TrieNode root = new TrieNode();
    public void insert(String s){
        TrieNode node = root;
        for(int i =0 ; i< s.length() ; i++){
            char c = s.charAt(i);
            if(node.child[c - 'a'] == null){
                node.child[c - 'a'] = new TrieNode();
                node = node.child[c - 'a'];
            }else{
                node = node.child[c - 'a'];
            }
        }
        node.isEnd = true;
        node.val = s;
    }
}
class TrieNode{
    public TrieNode[] child = new TrieNode[26];
    public String val;
    public boolean isEnd = false;
}
