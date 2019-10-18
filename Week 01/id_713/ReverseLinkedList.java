package id_713;

import java.util.Stack;

/**
 * 206. Reverse Linked List
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 88. 合并两个有序数组
     */
    public static class MergeSortedArray {
        /*
        思路:
        1. nums1 的空间都集中在尾部, 可以考虑从后向前处理数据
        2. 设计指针分别指向 nums1 和 nums2 的有效数据, 和一个指针, 指向nums1 的尾部
        3. 从后往前遍历, 空值的槽(slot)接收大的数字, 谁大赋值过去, 并往前移动指针
        4. 遍历结束后, nums2 有数据没有拷贝完全, 拷贝到nums1 的前面
         */

        public void merge(int[] nums1, int m, int[] nums2, int n) {

            int p1 = m - 1, p2 = n - 1, p0 = m + n - 1;

            while (p1 >= 0 && p2 >= 0) {
                nums1[p0--] = (nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--]);
            }

            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }

    }

    /**
     * 42. 接雨水
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * 示例:
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     */
    public static class TrappingRainWater {

        public int trap(int[] height) {
            int sum = 0;
            Stack<Integer> stack = new Stack<>();
            int current = 0;
            while (current < height.length) {
                //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
                while (!stack.empty() && height[current] > height[stack.peek()]) {
                    int h = height[stack.peek()]; //取出要出栈的元素
                    stack.pop(); //出栈
                    if (stack.empty()) { // 栈空就出去
                        break;
                    }
                    int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                    int min = Math.min(height[stack.peek()], height[current]);
                    sum = sum + distance * (min - h);
                }
                stack.push(current); //当前指向的墙入栈
                current++; //指针后移
            }
            return sum;

        }
    }
}
