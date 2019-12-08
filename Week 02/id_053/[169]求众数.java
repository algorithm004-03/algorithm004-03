//给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在众数。 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        //1、只能想到暴力法，对数组进行遍历后，在遍历哈希表得到众数，时间复杂度为O(n)
        Map<Integer,Integer> map = new HashMap<>();
        for (int i =0;i<nums.length;i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) +1);
            }else{
                map.put(nums[i],1);
            }
        }
        for(Integer key:map.keySet()) {
            if(map.get(key) > nums.length/2) {
                return key;
            }
        }
        return -1;
    }

}
}
//leetcode submit region end(Prohibit modification and deletion)
