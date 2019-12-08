
//One loop, build mapping for each element, meanwhile check against the mapping for target - element
public class Solution {
    public int[] TwoSum(int[] nums, int target) {
    
        //key: element value: index
        Dictionary<int, int> map = new Dictionary<int, int>(nums.Length);
        for (int i = 0; i < nums.Length; i++) {
            if (map.ContainsKey(target - nums[i])) {
                return new int[] {map[target - nums[i]], i};
            }
            if (!map.ContainsKey(nums[i])) {
                map.Add(nums[i], i);
            }
        }
        throw new ArgumentException();
    }
}