public class Solution {
    public void Merge(int[] nums1, int m, int[] nums2, int n) {
        //bounds checking
        if (nums2.Length == 0)
            return;
        
        int newLength = m + n;
        int k = newLength - 1;
        
        //nums1 index
        int i = m - 1;

        //nums2 index
        for (int j = n - 1; j >= 0;) {
            if (i >= 0) {
                if (nums2[j] > nums1[i]) {
                    nums1[k--] = nums2[j--];
                }
                else {
                    nums1[k--] = nums1[i--];
                }
            }
            //copy rest of nums2
            else {
                nums1[k--] = nums2[j--];
            }
                
        }
        //copy rest of nums1
        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }
    }
}

