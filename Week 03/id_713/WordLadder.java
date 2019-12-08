package id_713;

import javafx.util.Pair;

import java.util.*;

/**
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * <p>
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出: 5
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * <p>
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: 0
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordLadder {


    /*
    思路: 广度优先搜索
    利用广度优先搜索搜索从 beginWord 到 endWord 的路径。

    1. 对给定的 wordList 做预处理，找出所有的通用状态。将通用状态记录在字典中，键是通用状态，值是所有具有通用状态的单词。
    2. 将包含 beginWord 和 1 的元组放入队列中，1 代表节点的层次。我们需要返回 endWord 的层次也就是从 beginWord 出发的最短距离。
    3. 为了防止出现环，使用访问数组记录。
    4. 当队列中有元素的时候，取出第一个元素，记为 current_word。
    5. 找到 current_word 的所有通用状态，并检查这些通用状态是否存在其它单词的映射，这一步通过检查 all_combo_dict 来实现。
    6. 从 all_combo_dict 获得的所有单词，都和 current_word 共有一个通用状态，所以都和 current_word 相连，因此将他们加入到队列中。
    7. 对于新获得的所有单词，向队列中加入元素 (word, level + 1) 其中 level 是 current_word 的层次。
    8. 最终当你到达期望的单词，对应的层次就是最短变换序列的长度。
        标准广度优先搜索的终止条件就是找到结束单词。
     */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = beginWord.length(); // 因为题目描述, 长度都一样

        Map<String, ArrayList<String>> dict = new HashMap<>(); // 定义字典, key是泛化字符串, value是原字符串的集合

        for (String word : wordList) { // 构造泛化字符与原字符的映射关系 (无向无权图)
            for (int i = 0; i < length; i++) {
                String newKey = word.substring(0, i) + '*' + word.substring(i + 1, length); // hit -> *it
                ArrayList<String> list = dict.getOrDefault(newKey, new ArrayList<>());
                list.add(word);
                dict.put(newKey, list);
            }
        }
        // 最终成为 *ot -> [hot, dot, lot]这样

        // 定义队列, 元素为 原始词和层级, 并放入beginWord
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        // 定义访问记录
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        // BFS
        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String word = node.getKey();
            Integer level = node.getValue();

            for (int i = 0; i < length; i++) {
                // 构造泛化词, 并从泛化词的图中获取相邻节点
                String newKey = word.substring(0, i) + '*' + word.substring(i + 1, length);
                ArrayList<String> list = dict.getOrDefault(newKey, new ArrayList<>());

                for (String str : list) {
                    if (word.equals(str)) return level + 1; // 如果找到对应的原始词, 则返回当前层+1, 也就是多少步

                    if (!visited.containsKey(str)) { // 继续深度优选搜索
                        visited.put(str, true); // 添加访问记录
                        queue.add(new Pair<>(str, level + 1)); // 下一层级的元素, level需要加一
                    }
                }
            }

        }
        return 0;
    }

}