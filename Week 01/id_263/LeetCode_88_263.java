package io.beansoft.pencil.leetcode;


/**
 * @author beanlam
 * @version 1.0
 * @date 2019-10-20 15:28
 */
public class LeetCode_88_263 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int maxIndex1 = m - 1;
        int maxIndex2 = n - 1;

        int currentMaxIndex = m + n -1;

        while (true) {
            if (maxIndex1 < 0) {
                while(maxIndex2 >= 0) {
                    nums1[currentMaxIndex--] = nums2[maxIndex2--];
                }

                break;
            }

            if (maxIndex2 < 0) {
                while (maxIndex1 >= 0) {
                    nums1[currentMaxIndex--] = nums1[maxIndex1--];
                }
                break;
            }

            if (nums1[maxIndex1] == nums2[maxIndex2]) {
                nums1[currentMaxIndex--] = nums1[maxIndex1--];
                nums1[currentMaxIndex--] = nums2[maxIndex2--];
                continue;
            }

            if (nums1[maxIndex1] > nums2[maxIndex2]) {
                nums1[currentMaxIndex--] = nums1[maxIndex1--];
                continue;
            }

            if (nums1[maxIndex1] < nums2[maxIndex2]) {
                nums1[currentMaxIndex--] = nums2[maxIndex2--];
                continue;
            }
        }

    }
}
