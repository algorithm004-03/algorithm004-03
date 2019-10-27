/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wusonghui@bubi.cn
 * @since 1.0.0 2019/10/17 22:50
 */
public class LeetCode_283_593 {
    /**
     * 解法一：找出非零的数字，跟零的位置的数字不断交换位置。
     * 定义两个指针，定义两个 i j 两个指针，i 遍历使用，j 作为记录零的位置。当然，i == j 的时候，不需要交换位置。
     * [0,1,0,3,12] i = 0,j = 0;  i == j，不进行交换，i++
     * [0,1,0,3,12] i = 1,j = 0; [i] != 0, [j] = [i] [i] = 0 ,j++,i++
     * [1,0,0,3,12] i = 2,j = 1; [i] == 0,i++
     * [1,0,0,3,12] i = 3,j = 1; [i] != 0, [j] = [i] [i] = 0 ,j++,i++
     * [1,3,0,0,12] i = 4,j = 2; [i] != 0, [j] = [i] [i] = 0 ,j++,i++
     * [1,3,12,0,0] 遍历完成
     *
     * @param nums
     */
    public void moveZeroesOne(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    /**
     * 解法二：先找出非零的数字，后面补零
     */
    public void moveZeroesTwo(int[] nums) {
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                count++;
            } else if (count > 0) {
                // 前面几个零
                nums[i - count] = nums[i];
                nums[i] = 0;
            }
        }
        for (int i = length - count; i < length; i++) {
            nums[i] = 0;
        }
    }

}