class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int index = 0;
    //traverse nums2
    for (int i = 0; i < n; i++) {
      //traverse nums1 from last modified index++ to last index of current nums1 avaliable index
      for (int j = index; j <= m + i; j++) {
        //if at last index, no element in nums1 is greater than the value in nums2, just replace it
        if (j == m + i) {
        } else if (nums1[j] > nums2[i]) {
          for (int k = m + i - 1; k >= j; k--) {
            nums1[k + 1] = nums1[k];
          }
        } else {
          continue;
        }
        nums1[j] = nums2[i];
        index = j + 1;
        break;
      }
    }
  }
  
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    System.arraycopy(num2, 0, mums1, nums1, m, n);
    Arrays.sort(nums1);
  }
  
  //双指针, 从前往后, 额外空间 O(m)空间复杂度 O(n+m)时间复杂度
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] nums1_copy = new int[m];
    System.arraycopy(nums1, 0,nums1_copy,0,m);
    
    int p = 0, p1 = 0, p2 = 0;
    while ( p1 < m && p2 < n)
      nums1[p++] = nums1_copy[p1] > nums2[p2]?nums2[p2++]:nums1_copy[p1++];
    
    if (p1 < m)
      System.arraycopy(nums1_copy, p1, nums1, p, m-p1);
    if (p2 < n)
      System.arraycopy(nums2, p2, nums1, p, n-p2);
  }
  //双指针, 从后往前, 额外空间 O(m)空间复杂度 O(n+m)时间复杂度
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int p = m + n - 1, p1 = m - 1, p2 = n - 1;
    while ( -1 < p1 && -1 < p2)
      nums1[p--] = nums1[p1] < nums2[p2]?nums2[p2--]:nums1[p1--];
    
    if (-1 < p2)
      System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
//        while (-1 < p2)
//            nums1[p--] = nums2[p2--];
  }
}