import java.util.Arrays;

/**
 * 求众数：求一个数组中出现次数大于n/2的元素
 * @author L
 *
 */
public class LeetCode_169_138 {
	/**
	 * 暴力方式
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		int count = 0;
		for(int i=0;i<nums.length;i++) {
			for(int k=0;k<nums.length;k++) {
				if(nums[i] == nums[k]) {
					count ++;
				}
			}
			if(count >nums.length/2) {
				return nums[i];
			}
		}
		return -1;
    }
	
	/**
	 * 简化方式
	 * @param nums
	 * @return
	 */
	public int majorityElement2(int[] nums) {
		//排序
		Arrays.sort(nums);
		//如果存在众数,众数必定在nums.length/2的位置
		return nums[nums.length/2];
	}
	/**
	 * 投票方法
	 * @param nums
	 * @return
	 */
	public int majorityElement3(int[] nums) {
		int count = 0;
		int flag = nums[0];
		for(int num:nums) {
			if(count == 0) {
				flag = num;
			}
			count += (num == flag)?1:-1;
		}
		return flag;
	}
}
