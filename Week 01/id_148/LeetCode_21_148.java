package com.ning.test;

/**
 * 描述：头条面试的时候接触过
 *
 * @create 2019-10-20 下午10:53
 */
class ListNode21 {
    int val;
    ListNode21 next;

    ListNode21(int x) {
        val = x;
    }

    public ListNode21(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = nums[0];
        ListNode21 curr = this;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode21(nums[i]);
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode21 cur = this;
        while (cur != null) {
            s.append(cur.val + " -> ");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}

public class LeetCode_21_148 {

        /**
         *
         * @param l1 有序链表
         * @param l2 有序链表
         * @return 有序链表
         */
        public ListNode21 mergeTwoLists(ListNode21 l1, ListNode21 l2) {
            ListNode21 dummyNode = new ListNode21(-1);
            ListNode21 p1 = l1;
            ListNode21 p2 = l2;
            ListNode21 curNode = dummyNode;
            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    curNode.next = p1;
                    p1 = p1.next;
                } else {
                    curNode.next = p2;
                    p2 = p2.next;
                }
                curNode = curNode.next;
            }

            if (p1 == null) {
                curNode.next = p2;
            }
            if (p2 == null) {
                curNode.next = p1;
            }
            return dummyNode.next;
        }

        public static void main(String[] args) {
            int[] nums1 = {1, 3, 5, 7};
            int[] nums2 = {2, 4, 6};

            ListNode21 l1 = new ListNode21(nums1);
            ListNode21 l2 = new ListNode21(nums2);

            LeetCode_21_148 leetCode_21_148 = new LeetCode_21_148();
            ListNode21 mergeTwoLists = leetCode_21_148.mergeTwoLists(l1, l2);
            System.out.println(mergeTwoLists);

        }
}
