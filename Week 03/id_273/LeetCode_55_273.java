//55. 跳跃游戏

//解法1：贪心算法
//思路：从后往前贪心, 从最后一个位置Last开始, 向前寻找第一个跳跃后能够到Last的索引index, 找到后Last = index, 最后若Last指向0, 说明能够跳跃到达末尾
public boolean canJump(int[] nums) {
	int last = nums.length - 1;
	for (int i = nums.length - 1; i >= 0; i--) {
		if (nums[i] + i >= last) last = i;
	}
	return last == 0;
}

//解法2：回溯法		提交超时未通过
//思路：递归观察当前position能跳跃到达的所有位置, 若当前position到达末尾, 说明可达return true
public boolean canJump(int[] nums) {
	return canJumpRecur(nums, 0);
}

private boolean canJumpRecur(int[] nums, int position) {
	if (position == nums.length - 1) return true;
	//当前index能够到的最远位置
	int furtherJump = Math.min(nums.length - 1, position + nums[position]);
	for (int nextPos = position + 1; nextPos <= furtherJump; nextPos++) {
		if (canJumpRecur(nums, nextPos)) return true;
	}
	return false;
}