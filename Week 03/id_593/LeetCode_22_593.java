
/**
 * 22. 括号生成
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jaryoung
 * @version 3.0 BFS编写完成
 */
public class LeetCode_22_593 {

    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesisByDfs(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        generateParenthesisByDfs("", 0, 0, n);
        return result;
    }

    /**
     * 清空思路
     *
     * @param current 当前的括号的情况
     * @param left    左括号数量
     * @param right   右括号数量
     * @param n       括号总数
     */
    private void generateParenthesisByDfs(String current, int left, int right, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
        }

        if (left < n) {
            generateParenthesisByDfs(current + "(", left + 1, right, n);
        }
        if (right < left && right < n) {
            generateParenthesisByDfs(current + ")", left, right + 1, n);
        }
    }


    static class Node {
        /**
         * 当前得到的字符串
         */
        private String result;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String result, int left, int right) {
            this.result = result;
            this.left = left;
            this.right = right;
        }

        public String getResult() {
            return result;
        }
    }

    public List<String> generateParenthesisByBfs(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        Deque<Node> nodeDeque = new LinkedList<>();
        nodeDeque.offer(new Node("", n, n));
        int total = 2 * n;
        while (total > 0) {
            int size = nodeDeque.size();
            for (int i = 0; i < size; i++) {
                Node node = nodeDeque.poll();
                assert node != null;
                if (node.left > 0) {
                    nodeDeque.offer(new Node(node.result + "(", node.left - 1, node.right));
                }
                if (node.right > 0 && node.right > node.left) {
                    nodeDeque.offer(new Node(node.result + ")", node.left, node.right - 1));
                }
            }
            total--;
        }
        return nodeDeque.stream().map(Node::getResult).collect(Collectors.toList());
    }
