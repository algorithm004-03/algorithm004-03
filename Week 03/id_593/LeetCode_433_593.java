
/**
 * 433. 最小基因变化
 * <p>
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * <p>
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * <p>
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 * <p>
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 * <p>
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，
 * 请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 * <p>
 * 注意:
 * <p>
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 * 示例 1:
 * <p>
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * <p>
 * 返回值: 1
 * 示例 2:
 * <p>
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * <p>
 * 返回值: 2
 * 示例 3:
 * <p>
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * <p>
 * 返回值: 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jaryoung
 */
public class LeetCode_433_593 {

    private static final int EIGHT = 8;

    public int minMutationByDfs(String start, String end, String[] bank) {
        Set<String> dict = new HashSet<>(bank.length);
        dict.addAll(Arrays.asList(bank));
        int result = minMutationByDfs(start, end, 0, dict);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int minMutationByDfs(String start, String end, int level, Set<String> dict) {
        if (start.equals(end)) {
            return level;
        }
        int result = Integer.MAX_VALUE;
        if (dict.isEmpty()) {
            return result;
        }
        for (String s : dict) {
            if (s.equals(end) && diff(s, start) == 1) {
                return level + 1;
            } else if (diff(s, start) == 1) {
                Set<String> tempDict = new HashSet<>(dict);
                tempDict.remove(s);
                result = Math.min(result, minMutationByDfs(s, end, level + 1, tempDict));
            }

        }
        return result;
    }

    public int minMutationByBfs(String start, String end, String[] bank) {
        if (bank.length == 0) {
            return -1;
        }
        Set<String> dict = new HashSet<>(bank.length);
        dict.addAll(Arrays.asList(bank));
        Set<String> visited = new HashSet<>(dict.size());
        Deque<String> deque = new LinkedList<>();
        deque.add(start);
        visited.add(start);
        int result = 0;
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            level++;
            for (int i = 0; i < size; i++) {
                String current = deque.poll();
                assert current != null;
                for (String s : dict) {
                    if (visited.contains(s)) {
                        continue;
                    }
                    if (diff(current, s) == 1) {
                        if (end.equals(s)) {
                            return Math.min(result + 1, level);
                        }
                        deque.addLast(s);
                        visited.add(s);
                        result++;
                    }
                }
            }
        }
        return -1;
    }

    private int diff(String s, String start) {
        int diff = 0;
        for (int i = 0; i < EIGHT; i++) {
            if (s.charAt(i) != start.charAt(i)) {
                ++diff;
            }
        }
        return diff;
    }
}
