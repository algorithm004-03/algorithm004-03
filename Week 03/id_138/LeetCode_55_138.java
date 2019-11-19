/**
 *  跳跃游戏
 *     给定一个非负整数数组，你最初位于数组的第一个位置。
	数组中的每个元素代表你在该位置可以跳跃的最大长度。
	判断你是否能够到达最后一个位置。
 * @author L
 *
 */
public class LeetCode_55_138 {
	/**
	 * 
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
		// 对于数组中的每个位置，我们记录当前坐标是好 / 坏，记录在数组 flag 中，定义元素取值为 1 ，2，0。这种方法被称为记忆化。
		int[] flag = new int[nums.length];// 0:不确定 1：可以跳到 2：无法跳到
		flag[flag.length - 1] = 1;// 最后的一个元素不论取值均可以跳到自身的位置。
		for (int i = nums.length - 2; i >= 0; i--) {//从右侧开始标记
			int jump = Math.min(i + nums[i], nums.length - 1);//判断(索引i的位置+该位置最大可跳跃值)是否超过数组的长度-1
			for (int j = i + 1; j <= jump; j++) {
				if (flag[j] == 1) {//该位置可以跳跃到最后
					flag[i] = 1;
					break;
				}
			}
		}
		return flag[0] == 1;//第一个位置是否可以呢。

	}
	
	/**
	 * 贪心算法
	 * 从右向左循环，对于每个节点检查是否存在一种方式可以到达GOOD的位置(currentPosition+nums[currentPosition]>=leftmostGoodIndex)。
	 * 如果可行，则当前索引标记为GOOD，同时这个位置也成为最左侧的GOOD点。一直重复到数组的开头。如果坐标0的元素也可以，则成功。
	 */
	public boolean canJump2(int[] nums) {
		int last = nums.length-1;
		for(int i = last;i>=0;i--) {
			if(i+nums[i] >= last) {
				last = i;
			}
		}
		return last == 0;
	}
}
