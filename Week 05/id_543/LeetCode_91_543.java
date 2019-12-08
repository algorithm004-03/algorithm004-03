//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
// 示例 1:
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
//
//
// 示例 2:
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
//
// Related Topics 字符串 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] nums = new int[s.length()+1];
        nums[0] = 1;
        nums[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2;i <= s.length();i++){
            int first = Integer.parseInt(s.substring(i-1,i));
            int second = Integer.parseInt(s.substring(i-2,i));
            if(first >= 1 && first <=9){
                nums[i] += nums[i-1];
            }
            if(second >= 10 && second <=26){
                nums[i] += nums[i-2];
            }
        }
        return nums[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
