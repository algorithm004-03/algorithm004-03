import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=403 lang=java
 *
 * [403] Frog Jump
 *
 * https://leetcode.com/problems/frog-jump/description/
 *
 * algorithms
 * Hard (37.30%)
 * Likes:    643
 * Dislikes: 76
 * Total Accepted:    63K
 * Total Submissions: 168.4K
 * Testcase Example:  '[0,1,3,4,5,7,9,10,12]'
 *
 * A frog is crossing a river. The river is divided into x units and at each
 * unit there may or may not exist a stone. The frog can jump on a stone, but
 * it must not jump into the water.
 * 
 * Given a list of stones' positions (in units) in sorted ascending order,
 * determine if the frog is able to cross the river by landing on the last
 * stone. Initially, the frog is on the first stone and assume the first jump
 * must be 1 unit.
 * 
 * 
 * If the frog's last jump was k units, then its next jump must be either k -
 * 1, k, or k + 1 units. Note that the frog can only jump in the forward
 * direction.
 * 
 * Note:
 * 
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 2^31.
 * The first stone's position is always 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * [0,1,3,5,6,8,12,17]
 * 
 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,
 * third stone at the 3rd unit, and so on...
 * The last stone at the 17th unit.
 * 
 * Return true. The frog can jump to the last stone by jumping 
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
 * 2 units to the 4th stone, then 3 units to the 6th stone, 
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 * 
 * 
 * 
 * Example 2:
 * 
 * [0,1,2,3,4,8,9,11]
 * 
 * Return false. There is no way to jump to the last stone as 
 * the gap between the 5th and 6th stone is too large.
 * 
 * 
 */



// 在动态规划方法中，我们会利用散列表 mapmap，对于散列表中的 key:valuekey:value，
// keykey 表示当前石头的位置，valuevalue 是一个包含 jumpsizejumpsize 的集合，
// 其中每个 jumpsizejumpsize 代表可以通过大小为 jumpysizejumpysize 的一跳到达当前位置。
// 首先我们对散列表初始化，keykey 为所有石头的位置，除了位置 0 对应的 valuevalue 为包含
// 一个值 0 的集合以外，其余都初始化为空集。接下来，依次遍历每个位置上的石头。
// 对于每个 currentPositioncurrentPosition，遍历 valuevalue 中每个 jumpsizejumpsize，
// 判断位置 currentPosition + newjumpsizecurrentPosition+newjumpsize 是否存在于 mapmap 中，
// 对于每个 jumpsizejumpsize，newjumpsizenewjumpsize 分别为 jumpsize-1jumpsize−1，jumpsizejumpsize，jumpsize+1jumpsize+1。

// 如果找到了，就在对应的 valuevalue 集合里新增 newjumpsizenewjumpsize。重复这个过程直到结束。
// 如果在结束的时候，最后一个位置对应的集合非空，那也就意味着我们可以到达终点，如果还是空集那就意味着不能到达终点。

// @lc code=start
class Solution {
    public boolean canCross(int[] stones) {
        //2019.11.15 动态规划方法
        HashMap<Integer,Set<Integer>> map = new HashMap<>();
        for(int i=0;i<stones.length;i++){
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(0);

        for(int i=0;i<stones.length;i++){
            for(int k : map.get(stones[i])){
                for(int step=k-1;step<=k+1;step++){
                    if(step>0 && map.containsKey(stones[i] + step)){
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length-1]).size()>0;
    }
}
// @lc code=end

