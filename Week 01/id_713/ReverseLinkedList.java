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

    /**
     * 641. 设计循环双端队列
     */
    public static class MyCircularDeque {
        /*
        思路:
        控制头尾指针, 两者之间的元素为队列中的数据
         */

        // 定义存储结构为 数组
        private int[] data;
        // 定义头指针
        private int head;
        // 定义尾指针
        private int tail;
        // 定义容量
        private int capacity;
        // 定义当前存储数据的量值
        private int size;

        /**
         * 构造方法
         *
         * @param k 初始容量
         */
        public MyCircularDeque(int k) {
            data = new int[k];
            head = tail = -1;
            capacity = k;
            size = 0;
        }


        /**
         * 头部插入
         *
         * @param value 值
         * @return 是否成功
         */
        public boolean insertFront(int value) {
            if (isFull()) return false; // 如果满仓, 返回失败
            // 头部插入从数组右侧开始, 插入后head向左移动
            head = (head - 1 + capacity) % capacity;
            data[head] = value;
            size++;
            if (size == 1) { // 首次插入时, 头=尾
                tail = head;
            }
            return true;
        }

        /**
         * 尾部插入
         *
         * @param value 值
         * @return 是否成功
         */
        public boolean insertLast(int value) {
            if (isFull()) return false;
            tail = (tail + 1) % capacity;
            data[tail] = value;
            size++;
            if (size == 1) {
                head = tail;
            }
            return true;
        }

        /**
         * 从头部删除
         *
         * @return 是否成功
         */
        public boolean deleteFront() {
            if (isEmpty()) return false;
            head = (head + 1) % capacity;
            size--;
            return true;
        }


        /**
         * 从尾部删除
         *
         * @return 是否成功
         */
        public boolean deleteLast() {
            if (isEmpty()) return false;
            tail = (tail - 1 + capacity) % capacity;
            size--;
            return true;
        }

        /**
         * 查询头部元素
         *
         * @return 元素值
         */
        public int getFront() {
            if (isEmpty()) return -1;
            return data[head];
        }

        /**
         * 查询尾部元素
         *
         * @return 元素值
         */
        public int getRear() {
            if (isEmpty()) return -1;
            return data[tail];
        }

        /**
         * 是否为空
         * @return
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 是否满仓
         */
        public boolean isFull() {
            return size == capacity;
        }

    }
}
