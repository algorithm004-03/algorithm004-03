package org.geektime.weak01;

import java.util.*;


/**
 * Created by fukan on 2019/10/22.
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 排序 加 双指针。在遍历的过程中注意减枝和去重
 */
public class LeetCode_15_178 {
    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        LeetCode_15_178 instance = new LeetCode_15_178();
        //instance.threeSum1(nums);
//        instance.threeSum2(nums);
//        instance.threeSum3(nums);
//        instance.threeSum4(nums);

    }


    /**
     * 暴力破解AC超出时间限制了T_T
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> answer = new ArrayList();
        List<Integer> item = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                for (int z = j + 1; z < nums.length; ++z) {
                    if (nums[i] + nums[j] + nums[z] == 0) {
                        item = Arrays.asList(nums[i], nums[j], nums[z]);
                        Collections.sort(item);
                        if (!answer.contains(item)) {
                            answer.add(item);
                        }

                    }
                }
            }
        }
        return answer;
    }

    /**
     * 暴力法搜索为 O(N^3)的时间复杂度，可通过双指针动态消去无效解来优化效率。
     * 双指针法铺垫： 先将给定 nums 排序，复杂度为 O(NlogN)。
     * 双指针法思路： 固定 3 个指针中最左（最小）数字的指针 k，双指针 i，j 分设在数组索引 (k, len(nums))两端，
     * 通过双指针交替向中间移动，记录对于每个固定指针 k 的所有满足 nums[k] + nums[i] + nums[j] == 0 的 i,j 组合：
     * 当 nums[k] > 0 时直接break跳出：因为 nums[j] >= nums[i] >= nums[k] > 0，即 3 个数字都大于 0 ，
     * 在此固定指针 k 之后不可能再找到结果了。
     * 当 k > 0且nums[k] == nums[k - 1]时即跳过此元素nums[k]：因为已经将 nums[k - 1] 的所有组合加入到结果中，
     * 本次双指针搜索只会得到重复组合。
     * i，j 分设在数组索引 (k, len(nums)) 两端，当i < j时循环计算s = nums[k] + nums[i] + nums[j]，
     * 并按照以下规则执行双指针移动：
     * 当s < 0时，i += 1并跳过所有重复的nums[i]；
     * 当s > 0时，j -= 1并跳过所有重复的nums[j]；
     * 当s == 0时，记录组合[k, i, j]至res，执行i += 1和j -= 1并跳过所有重复的nums[i]和nums[j]，防止记录到重复组合。
     * 左右夹逼,中心迫近的思想
     * 摘自leetcode
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        // - 2 减去左指针 和 右指针的长度
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;

            //>0 防止数组下标越界,假如K值与前一个K值相等,则不处理,应为效果相同,节约计算资源
            if (k > 0 && nums[k] == nums[k - 1]) continue;

            //i是左指针位置 j是右指针位置
            int i = k + 1, j = nums.length - 1;

            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                //小于目标值时,左指针向右迫近。
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                    //大于目标值时,右指针向左迫近。
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }

        return res;
    }


    /**
     * 暴力破解 性能极差。
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.EMPTY_LIST;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(-nums[i] - nums[j])
                        && map.get(-nums[i] - nums[j]) != i
                        && map.get(-nums[i] - nums[j]) != j
                        && -nums[i] - nums[j] >= nums[j]) {
                    if (!hashSet.contains(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]))) {
                        hashSet.add(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]));
                        list.add(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]));
                    }
                }
            }
        }

        return list;
    }

    /**
     * 使用linkedlist在增加数组时,减少了所用资源
     */
    public List<List<Integer>> threeSum4(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (1 == 0 || (i > 0) && nums[i] != nums[i - 1]) {
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

}
