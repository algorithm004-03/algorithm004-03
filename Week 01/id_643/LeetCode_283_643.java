


一维度数数组坐标变化使用，i  j 两个坐标
to do 前面两种方法是用两个下标从左到右的进行移动，遇到部位零的数字就是放到最左边。


public void moveZeroes(int[] nums) {

	if(nums == null || nums.length == 0 ) return;

	int inserPos = 0;

	for(int num : nums) {
		if(num != 0) nums[inserPos++] = num;
	}

	while(inserPos < nums.length) 
		nums[inserPos++] = 0;


	int j = 0;
	for(int i = 0; i < nums.length; i++) {

		if(nums[i] != 0) {

			int temp = nums[j];

			nums[j] = nums[i];

			nums[i] = temp;

			j++;
		}
	}
//后面一种是滚雪球的方法

int snowBallSize = 0;
for(int i = 0 ; i < nums.length; i++){
	
	if(nums[i] == 0) snowBallSize++;

	else if(snowBallSize > 0){

		int t = num[i];

		num[i]=0;

		num[i-snowBallSize] = t;

	}

}













}





