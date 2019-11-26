/**
 * @author eazonshaw
 * @date 2019/11/3  19:17
 * 题目： 55. 跳跃游戏
 *
 * 描述：给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 例子：
 * 输入: [2,3,1,1,4]
 * 输出: true
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 *
 */
public class LeetCode_55_243 {

    //利用贪心算法，假设从终点开始，从后往前进行遍历，每一步都跳最远路径，判断能不能到达起点
    public boolean canJump(int[] nums) {

        //终点坐标
        int len = nums.length;

        //记录当前坐标可以到达的最远坐标
        int canReachable = nums[len-1];

        for(int i=len-1;i>=0;i--){
            //实时更新从后往前遍历过程中能达到的最远坐标位置
            if(nums[i] + i >= canReachable){
                canReachable = i;
            }
        }
        //最远坐标位置是起点
        return canReachable == 0;
    }


}
