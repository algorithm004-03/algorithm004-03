package week_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_46_333 {
//    private static List<List<Integer>> lists = new ArrayList<List<Integer>>();

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            return lists;
        } else {
            allSort(lists, nums, new Stack<Integer>());
            return lists;
        }
    }

    private  static void allSort(List<List<Integer>> lists, int[] nums, Stack<Integer> stack) {
        if (stack.size() == nums.length) {
            lists.add(new ArrayList<>(stack));
            return;
        }

        for (int num : nums) {
            if (stack.contains(num)) {
                continue;
            }
            stack.push(num);
            allSort(lists, nums, stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> result = permute(nums);
        System.out.print("[");
        for(List<Integer> list : result) {
            System.out.print("[");
            for(Integer num : list) {
                System.out.print("" + num + ",");
            }
            System.out.print("],");
        }
        System.out.print("]");
    }
}
