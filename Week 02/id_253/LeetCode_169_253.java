class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxnum=0; int maxcount=0;
        for(int num : nums){
            int count = map.getOrDefault(num,0) + 1;
            map.put(num,count);
            if(count > maxcount){
                maxcount=count;
                maxnum=num;
            }
        }
        return maxnum;
    }
}
