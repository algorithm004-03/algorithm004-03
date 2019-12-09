/**
 * LeetCode 88题
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * @author northleaf
 * @create 2019年10月18日
 */
public class LeetCode_88_598 {

    /**
     * 合并两个有序数组，默认num1的空间大于等于nums2
     * 借助第三个数组进行合并
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //构造第三个数组
        int[] num3 = new int[m];
        for(int i =0;i< m;i++){
            num3[i] = nums1[i];
        }
        //循环遍历num2 数组，使用两个指针，一个指针指向nums2，一个指针指向nums3
        int j = 0;
        int i = 0;
        //s指针指向数组1
        int s = 0;
        //遍历数据num2与num3，将小的值依次添加入num1
        while (i < nums2.length && j < num3.length){
            if(nums2[i]<= num3[j]){
                nums1[s++] = nums2[i++];
            }else{
                nums1[s++] = num3[j++];
            }
        }
        //将未遍历的元素直接添加到num1
        while (i<nums2.length){
            nums1[s++] = nums2[i++];
        }
        while (j<num3.length){
            nums1[s++] = num3[j++];
        }
    }

}
