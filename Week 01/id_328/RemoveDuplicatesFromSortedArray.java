public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int nonRepeatIndex = 0;
        for(int i = 0; i< nums.length ;i ++){
            if(nums[nonRepeatIndex] != nums[i]){
                nonRepeatIndex++;
                nums[nonRepeatIndex] = nums[i];
            }
        }
        return nonRepeatIndex + 1;
    }
}