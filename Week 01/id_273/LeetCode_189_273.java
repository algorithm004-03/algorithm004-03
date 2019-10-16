//128 数组旋转

class Solution {
	//1. 暴力解法
	//时间复杂度为O(n*k)
	//空间复杂度为O(1)
	//可以通过System.numscopy进行数组移动实现
	//也可以通过for循环移动元素实现,经过测试后还是循环移动的效率更高
	public void rotate(int[] nums, int k) {
		if (k == 0) return;
		//优化：省去多余的重复旋转
		k = k%nums.length;
        for(int i =  0;i< k ;i++) {
            int temp = nums[j];
            nums[j] = pre;
            pre = temp;
        }
    }
	
	//2. 使用反转reverse
	//时间复杂度O(n),若n=100 需要3次反转 每次交换n/2=50次
	//空间复杂度O(1)
	//首先所有元素反转，然后反转前k个元素，再反转后n-k个元素
	//假设n = 6 k = 2
	//初始1 2 3 4 5 6
	//反转6 5 4 3 2 1
	//反转前k个5 6 4 3 2 1
	//反转后n-k个 得到结果5 6 1 2 3 4
	public void rotate2(int[] nums, int k) {
		//优化：省去多余的重复旋转
		if (k == 0) return;
		k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
	
	
	//3. 开辟一个新数组，按正确的位置将值放进去
	//时间复杂度O(n)
	//空间复杂度O(n) 需要开辟nums.length长度的数组
	public void rotate(int[] nums, int k) {
		if(nums.length <= 1){
            return;
        }
        int temp[] = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
			//实现的关键 (i+k)%nums.length 恰好为每个元素旋转k次后的正确位置
            temp[(i+k)%nums.length] = nums[i];
        }
        for(int i = 0;i<nums.length;i++){
            nums[i] = temp[i];
        }
    }
}