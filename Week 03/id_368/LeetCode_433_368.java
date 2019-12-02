import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_433_368 {

    /*一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
    假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
    例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
    与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
    现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
    注意:
    起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
    所有的目标基因序列必须是合法的。
    假定起始基因序列与目标基因序列是不一样的。
    链接：https://leetcode-cn.com/problems/minimum-genetic-mutation*/

    public static void main(String[] args) {

    }

    public int minMutation(String start, String end, String[] bank) {
        char[] words = {'A', 'C', 'G', 'T'};
        Set<String> dist = new HashSet<>(Arrays.asList(bank));
        if (!dist.contains(end)) {
            return -1;
        }
        int depth = 0;
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(start);
        endSet.add(end);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            depth++;
            dist.removeAll(beginSet);
            Set<String> levels = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char temp = chars[i];
                    for (char ch : words) {
                        chars[i] = ch;
                        String str = String.valueOf(chars);
                        if (dist.contains(str)) {
                            levels.add(str);
                            if (endSet.contains(str)) {
                                return depth;
                            }
                        }
                    }
                    chars[i] = temp;
                }
            }
            beginSet = levels;
        }
        return -1;
    }
}
