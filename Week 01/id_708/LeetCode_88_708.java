// Compare from the end of the array so that we don't need to move a lot of elements
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1, p2 = n-1;
        
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p1+p2+1] = nums1[p1];     
                p1--;
            } else {
                nums1[p1+p2+1] = nums2[p2];
                p2--; 
            }
        }
        while (p2 >= 0) {
            nums1[p1+p2+1] = nums2[p2];
            p2--;
        }
    }
}

// Compare from the start of array
class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = 0;
        for (int i = 0; i < nums2.length; i++) {
            // Ignore the smaller Numbers in nums1
            int nums1NewSize = m + i;
            while (p < nums1NewSize && nums1[p] <= nums2[i]) p++;
            // Moves array elements and inserts nums1's elements into nums1
            for (int j = nums1NewSize; j > p; j--) nums1[j] = nums1[j-1];
            nums1[p] = nums2[i];
        }
    }
}