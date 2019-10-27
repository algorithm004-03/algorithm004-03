package id_693;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Desc 46. 全排列   https://leetcode-cn.com/problems/permutations/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/26
 */
public class LeetCode_46_693 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> numArr = new ArrayList<>();
        for (int num : nums) {
            numArr.add(num);
        }
        backtrack(list, numArr, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> numArr, int first) {
        if (first == numArr.size()) {
            list.add(new ArrayList<>(numArr));
        }
        for (int i = first; i < numArr.size(); i++) {
            Collections.swap(numArr, first, i);
            backtrack(list, numArr, first + 1);
            Collections.swap(numArr, first, i);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_46_693().permute(new int[]{1, 1, 2}));
    }
/*
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

    输入: [1,2,3]
    输出:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]
在真实

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
}
