/*
思路
如果每一个单词都去进行一次dfs
那么单词公共的前缀在dfs时候会被查找多次，因此可以先将所有单词构建字典树
dfs时候往下一层递归的条件是相邻的节点对应的字符在字典树当前节点中有对应的边
每次往下递归都需要更新字典树中搜索位置，如果当前字典树节点是一个end节点，
表示找到一个单词，用字典树避免了相同前缀的重复搜索
*/

import java.util.*;

class TrieNode {
    TrieNode[] edges;
    boolean isEnd;

    TrieNode() {
        edges = new TrieNode[26];
        isEnd = false;
    }

    TrieNode addSubNode(char ch) {
        if (edges[ch-'a'] != null) {
            return edges[ch - 'a'];
        }

        edges[ch-'a'] = new TrieNode();
        return edges[ch - 'a'];
    }

    TrieNode nextNode(char ch) {
        return edges[ch - 'a'];
    }
}


class Trie {


    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            curNode = curNode.addSubNode(word.charAt(i));
        }

        curNode.isEnd = true;
    }

    public TrieNode getRoot() {
        return root;
    }
}

class Solution {
    private class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }


    private void dfs(Pos curPos, boolean[][] visited, char[] path, Set<String> result, char[][] board, TrieNode curNode, int curLevel, char curChar) {
        visited[curPos.i][curPos.j] = true;
        path[curLevel] = curChar;

        if (curNode.isEnd) {
            result.add(new String(path, 0, curLevel+1));
        }

        if ((curPos.i + 1 < board.length)  && (curNode.edges[board[curPos.i + 1][curPos.j]-'a'] != null)  && (!visited[curPos.i + 1][curPos.j])) {
            dfs(new Pos(curPos.i + 1, curPos.j), visited, path, result, board, curNode.edges[board[curPos.i + 1][curPos.j]-'a'], curLevel + 1, board[curPos.i + 1][curPos.j]);
        }

        if ((curPos.i - 1 >= 0)  && (curNode.edges[board[curPos.i - 1][curPos.j]-'a'] != null) && (!visited[curPos.i - 1][curPos.j])) {
            dfs(new Pos(curPos.i - 1, curPos.j), visited, path, result, board, curNode.edges[board[curPos.i - 1][curPos.j]-'a'], curLevel + 1, board[curPos.i - 1][curPos.j]);
        }

        if ((curPos.j + 1 < board[0].length)  && (curNode.edges[board[curPos.i][curPos.j + 1]-'a'] != null)  && (!visited[curPos.i][curPos.j + 1])) {
            dfs(new Pos(curPos.i, curPos.j + 1), visited, path, result, board, curNode.edges[board[curPos.i][curPos.j + 1]-'a'], curLevel + 1, board[curPos.i][curPos.j + 1]);
        }

        if ((curPos.j - 1 >= 0)  && (curNode.edges[board[curPos.i][curPos.j - 1]-'a'] != null)  && (!visited[curPos.i][curPos.j - 1])) {
            dfs(new Pos(curPos.i, curPos.j - 1), visited, path, result, board, curNode.edges[board[curPos.i][curPos.j - 1]-'a'], curLevel + 1, board[curPos.i][curPos.j - 1]);
        }

        visited[curPos.i][curPos.j] = false;
    }


    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        Set<String> result = new HashSet<>();
        int strMaxLen = 0;

        if (words == null) {
            return new ArrayList<String>(result);
        }

        if ((board == null) || (board[0] == null)) {
            return new ArrayList<String>(result);
        }

        for (String s : words) {
            trie.insert(s);
            strMaxLen = Math.max(s.length(), strMaxLen);
        }

        TrieNode root = trie.getRoot();
        char[] path = new char[strMaxLen];


        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (root.edges[board[i][j]-'a'] == null) {
                    continue;
                }

                dfs(new Pos(i, j), visited, path, result, board, root.edges[board[i][j]-'a'], 0, board[i][j]);
                if (result.size() == words.length) {
                    break;
                }
            }
        }

        return new ArrayList<String>(result);
    }
/*
    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };

        new Solution().findWords(board, new String[] {"oath","pea","eat","rain"});
    }
    */

/*
    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'a', 'b'},
                {'a', 'a'},
        };

        new Solution().findWords(board, new String[] {"aba","baa","bab","aaab","aaa","aaaa","aaba"});
    }
*/
}
