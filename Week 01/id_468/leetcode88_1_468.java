/**
 * @program: leetcode
 * @description: Merge Sorted Array
 * @author: 王瑞全
 * @create: 2019-10-2018:57
 **/


public class leetcode88_1_468 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         int one=m-1,two=n-1,length=n+m-1;
         while(one>=0&&two>=0){
             nums1[length--]=nums1[one]>nums2[two]?nums1[one--]:nums2[two--];
         }
         while(two>=0){
             nums1[length--]=nums2[two--];
         }
    }
}
