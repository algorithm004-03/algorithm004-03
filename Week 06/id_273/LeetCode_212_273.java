//212. 单词搜索II

//解法1：字典树+DFS回溯		执行用时：10ms
//思路：1. 创建一个字典树, 并将words存入字典树作为字符前缀
//		2. 遍历二维数组中的每一个字符, 判断当前字符对应字典树中的节点数组是否已经组成了想要的单词
//			若已经组成, 添加result字符串
//			若还未组成, 对其上下左右位置的字符深度优先递归
//时间复杂度：row = m, col = n, words.length = w, word的平均长度 = l
//				O(k*l)构建trie + O(m*n)遍历 + O(l)dfs的平均深度
//总结：通过字典树的数据结构, 就可以直接排除掉字符前缀不匹配的选项, 枝剪掉了很多不必要的递归
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, res, i, j);
            }
        }
        return res;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String s : words) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (node.next[c - 'a'] == null) node.next[c - 'a'] = new TrieNode();
                node = node.next[c - 'a'];
            }
            node.word = s;
        }
        return root;
    }
    
    private void dfs(char[][] board, TrieNode node, List<String> res, int i, int j) {
        char c = board[i][j];
        if (c == '#' || node.next[c - 'a'] == null) return;
        node = node.next[c - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        if (i > 0) dfs(board, node, res, i - 1, j);
        if (i < board.length - 1) dfs(board, node, res, i + 1, j);
        if (j > 0) dfs(board, node, res, i, j - 1);
        if (j < board[0].length - 1) dfs(board, node, res, i, j + 1);
        board[i][j] = c;
    }
}

class TrieNode {
    TrieNode next[] = new TrieNode[26]; 
    String word;
}