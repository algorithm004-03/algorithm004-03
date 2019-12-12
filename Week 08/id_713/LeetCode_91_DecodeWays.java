package id_713;

/**
 * 91. 解码方法
 */
public class LeetCode_91_DecodeWays {

    /*
    一条包含字母 A-Z 的消息通过以下方式进行了编码：

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26

    给定一个只包含数字的非空字符串，请计算解码方法的总数。

    示例 1:

    输入: "12"
    输出: 2
    解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。

    示例 2:

    输入: "226"
    输出: 3
    解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/decode-ways
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    /*
    分析:

    以22067举例, 从后往前遍历

        1. 首先提取如果为7, 只有1种 -> G
        2. 其次为67, 也只有一种 -> FG
        3. 067 -> 0
        4. 2067 -> (20 67) + (2 067)  = (20 67) -> TFG
        5. 22067 -> (2 2067) + (22 067) + (2 2067) -> BTFG

        得到规律:
        如果开始为0, 结果为0
        如果开始的数加上第二个数 <= 26. 结果为 (start + 1) + (start + 2)
        如果开始的数加上第二个数 > 26. 结果为 (start + 1)

        以上是递归的思路, 导致了大量重复的计算

        引入一个dp数组, 用来计算以某个字符为开始的解码数量, 动态规划是一个填表的过程
        递推方程:
        如果 nums[i] = 0, dp[i] = 0
        如果 nums[i] + nums[i + 1] <= 26
            dp[i] =dp[i + 1] + dp[i + 2]
        否则
            dp[i] = dp[i + 1]


        以2206为例, 假设此处 nums[]={2,2,0,6}, 新建一个数组
        int[] dp = new int[len + 1];
        之所以长度为len+1, 因为这样不需要将最后一个6单独处理, 并将dp[len]=1

         0   1   2   3   4
        [0   0   0   0   1] // 将 dp[len]=1, 算上0, 此时长度为 len + 1, 所以索引是 len
        [0   0   0   1   1] // 此时处理 dp[3], 按照递推式, 因为 nums[3] = 6,所以 dp[3] = 1
        [0   0   0   1   1] // 此时处理 dp[2], 按照递推式, 因为 nums[2] = 0,所以 dp[2] = 0
        [0   1   0   1   1] // 此时处理 dp[1], 按照递推式, 因为 nums[1]*10 + nums[2] = 20, 所以dp[1] = dp[2] + dp[3] = 1
        [1   1   0   1   1] // 此时处理 dp[0], 按照递推式, 因为 nums[0]*10 + nums[1] = 22, 所以dp[0] = dp[1] + dp[2] = 1

     */


    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        // 提取s的长度
        int n = s.length();

        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = (s.charAt(n - 1) == '0' ? 0 : 1);

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            if ((s.charAt(i) - '0' * 10 + s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }

        return dp[0];
    }

    public int numDecodingsPlus(String s) {
        if (s == null || s.length() == 0) return 0;

        // 提取s的长度
        int len = s.length();

        int help = 1; // 相当于 初始化 dp[len + 1[ = 1 的意思
        int res = (s.charAt(len - 1) != '0' ? 1 : 0); // 倒数第2个值, 也就是是

        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                help = res;
                res = 0;
                continue;
            }

            if ((s.charAt(i - '0') * 10 + s.charAt(i + 1 - '0')) <= 26) {
                res += help;
                help = res - help; // help用于存储res之前的值
            } else {
                help = res;
            }
        }

        return res;
    }

}
