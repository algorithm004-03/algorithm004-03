class Solution {
//个人理解的众数和题目中给出的众数是不一样的，
//个人理解是在一组树中出现次数最多的一个数。
//思路：对于数组中出现的任何一个数，都应该有一个计数器。
//      故得用键值对的形式的做题，以元素键，计数器为值。
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        int num = 0;
        int maxNum = 0;
        for(int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i],0) + 1;
            if (count > num) {
                num = count;
                maxNum = nums[i];
            } 
            map.put(nums[i],count);
        }
        return maxNum;
    }
}