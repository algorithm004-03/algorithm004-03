// Trie 树 + DFS
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    //深度优先便利字符数组
    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return; //当该字母遍历过，或者不在Trie树中 退出递归
        p = p.next[c - 'a'];
        // 当找到该节点单词加入结果集，同时清掉该节点的单词防止 le 找到后 找不到 leet 这样的单词
        if (p.word != null) {
            res.add(p.word);
            p.word = null;
        }

        board[i][j] = '#';  //遍历过的字母设置标识
        if (i > 0) dfs(board, i - 1, j ,p, res); // 左
        if (j > 0) dfs(board, i, j - 1, p, res); // 上
        if (i < board.length - 1) dfs(board, i + 1, j, p, res); //右
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res); //下
        board[i][j] = c;  //还原
    }

    //Trie树生成
    //链接存在。沿着链接移动到树的下一个子层。算法继续搜索下一个键字符。
    //链接不存在。创建一个新的节点，并将它与父节点的链接相连，该链接与当前的键字符相匹配。
    //当一个单词结束时，该单词存储在单词结尾的TrieNode.word中
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    //Trie树节点定义
    class TrieNode {
        TrieNode[] next = new TrieNode[26];  // 指向下个字母的26叉树
        String word;                         // 当前节点单词
    }

}