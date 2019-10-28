/**
 * @author eazonshaw
 * @date 2019/10/20  14:34
 *
 * 题目：189. 旋转数组
 * 链接：https://leetcode-cn.com/problems/rotate-array/
 * 描述：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class LeetCode_189_243 {

    /**
     * 1.暴力法：遍历所有元素，向右移动三次
     */
    public void rotate1(int[] nums, int k) {
        for(int j=0;j<k;++j){
            //next
            int next = nums[0];
            for(int i=0;i<nums.length-1;++i){
                int now = next;
                next = nums[i+1];
                nums[i+1] = now;
            }
            nums[0] = next;
        }
    }

    /**
     * 2.暴力法2：直接给距离k的值赋值，构成闭环
     */
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int now = start;
            int prev = nums[start];
            do {
                int next = (now + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                now = next;
                count++;
            } while (start != now);
        }
    }


}
