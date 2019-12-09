
import java.util.Arrays;

/**
 * 621. 任务调度器
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * <p>
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的最短时间。
 * <p>
 * 示例 1：
 * <p>
 * 输入: tasks = ["A","A","A","B","B","B"], n = 2
 * 输出: 8
 * 执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 * 注：
 * <p>
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/task-scheduler
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jaryoung
 * @version 1.0 默写官方题解
 */
public class LeetCode_621_593 {

    public int leastInterval(char[] tasks, int n) {
        int[] dict = new int[26];
        for (char c : tasks) {
            dict[c - 'A']++;
        }
        Arrays.sort(dict);
        // 某个任务最大执行次数 - 1
        int maxTimes = dict[25] - 1;
        // 增加虚拟空闲的槽
        int idleSlots = maxTimes * n;
        // dict[i] > 0 表示存在某个任务
        for (int i = 24; i >= 0 && dict[i] > 0; i--) {
            idleSlots = idleSlots - Math.min(dict[i], maxTimes);
        }
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }

}
