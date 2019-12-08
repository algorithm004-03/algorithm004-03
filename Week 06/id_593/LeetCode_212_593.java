
import java.util.ArrayList;
import java.util.List;

/**
 * 212. 单词搜索 II
 * <p>
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * <p>[
 * <p>  ['o','a','a','n'],
 * <p>  ['e','t','a','e'],
 * <p>  ['i','h','k','r'],
 * <p>  ['i','f','l','v']
 * <p>]
 * <p>
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * <p>
 * 提示:
 * <p>
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 分析单词搜索 2 用 Tire 树方式实现的时间复杂度，请同学们提交在第 6 周的学习总结中。 
 平均时间的时间复杂度：O(m*n)
 *
 * @author jaryoung
 */
public class LeetCode_212_593 {
    private static final char CHAR = '#';
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = Trie.buildTrie(words);
        List<String> result = new ArrayList<>(words.length);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char c = board[i][j];
        if (c == CHAR || node.get(c) == null) {
            return;
        }
        node = node.get(c);
        String word = node.getWord();
        if (word != null) {
            result.add(word);
            // 避免重复数据
            node.setWord(null);
        }
        board[i][j] = CHAR;
        for (int k = 0; k < 4; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != '#') {
                dfs(board, x, y, node, result);
            }
        }
        board[i][j] = c;
    }
}
