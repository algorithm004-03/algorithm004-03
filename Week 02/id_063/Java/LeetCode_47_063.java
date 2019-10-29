import java.util.*;

/*
思路

跟普通的全排列没本质区别，增强的点在于递归过程中需要判断当前产生的新序列是不是已经产生过的，
如果判断到当前生成的序列已经出现过了，再继续递归下去只可能得到已经出现过的序列，
这种情况进行减枝回溯即可， 只需要保证每一层递归添加的元素数值不重复就可以保证不会产生重复序列
先对序列进行排序，在递归时候就能比较快发现重复， 因为递归时候每一层都是顺序从左到右找新的元素
如果从左到右迭代时候元素数值是有序的，那么只需要维护一个上一次迭代选择的数值，就可以快速知道当前待选择
的元素是不是和前面已经选择过的重复了
 */


class Solution {
    private List<List<Integer>> dfs(List<List<Integer>> result, List<Integer> path, int[] choice, int[] nums, int curLevel, int maxLevel) {
        if (curLevel == maxLevel) {
            result.add(new ArrayList<Integer>(path));
            return result;
        }

        Integer lastVal = null;
        for (int i = 0; i < choice.length; i++) {
            if (choice[i] == 0) {
                if ((lastVal != null) && (lastVal == nums[i])) {
                    continue;
                }

                choice[i] = 1;
                path.add(nums[i]);

                lastVal = nums[i];
                dfs(result, path, choice, nums, curLevel+1, maxLevel);

                // 恢复现场
                choice[i] = 0;
                path.remove(path.size() - 1);
            }
        }

        return result;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        return dfs(new ArrayList<List<Integer>>(), new ArrayList<Integer>(nums.length), new int[nums.length], nums, 0, nums.length);
    }
}

