import java.util.Arrays;

/**
 * @author eazonshaw
 * @date 2019/12/1  9:11
 */
public class LeetCode_493_243 {

    //归并
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }

    //递归函数
    private int mergeSort(int[] nums,int begin,int end){
        //终止条件
        if(begin >= end)return 0;
        //下坠
        int mid = (begin + end) >> 1;
        int count = mergeSort(nums,begin,mid) + mergeSort(nums,mid+1,end);

        int i = begin,j = mid+1;
        while(i <= mid){
            while(j <= end && nums[i] > nums[j]*2L){
                j++;
            }
            //TODO 之前想着为什么不直接在循环里执行count++
            count += j - (mid + 1);
            i++;
        }
        //执行当前层逻辑
        //merge(nums,begin,mid,end);
        Arrays.sort(nums,begin,end+1);
        return count;
    }

    private int merge(int[] nums, int begin, int mid, int end) {
        int count = 0;
        int[] tmp = new int[end-begin+1];
        int i = begin,j = mid+1,k = 0;
        while (i<=mid && j<=end){
            tmp[k++] = nums[i] <= nums[j]?nums[i++] : nums[j++];
        }
        while (i<=mid){
            tmp[k++] = nums[i++];
        }
        while (j<=end){
            tmp[k++] = nums[j++];
        }
        for(int p = 0;p < tmp.length;p++){
            nums[begin+p] = tmp[p];
        }
        return count;
    }


}
