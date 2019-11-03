package study;

public class LeeCode_001_108 {

	public static int[] twoSum(int[] nums, int target) {

		int len = nums.length;
		int resultArray[] = new int[2];
        int indextemp[]= new int[2];
		for (int i = 0; i < len - 1; i++) {
			for (int j = i+1; j < len; j++) {
				int sum = nums[i] + nums[j];
				if (target == sum) {
					//resultArray[0] = nums[i];
					//resultArray[1] = nums[j];
					indextemp[0]=i;
					indextemp[1]=j;
				}
				
			}

		}

		return indextemp;

	}

	public static void main(String[] args) {

		int nums[] = { 2, 7, 11, 15 };
		int result[] = new int[2];
		result = twoSum(nums, 9);
		System.out.println("The result is " + result[0] + " and " + result[1]);

	}

}
