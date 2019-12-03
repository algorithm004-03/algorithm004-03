import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @program: leetcode
 * @description: Sliding Window Maximum
 * @author: 王瑞全
 * @create: 2019-10-1918:14
 **/


public class leetcode239_1_468 {

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums.length==0||k<0){
            return new int[]{};
        }
        Deque<Integer> deque=new ArrayDeque<>();
        int[] result=new int[nums.length-k+1];
        int r=0;
        for(int i=0;i<nums.length;i++){
            while(!deque.isEmpty()&&deque.peek()<i-k+1){
                deque.poll();
            }
            while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if(i>=k-1){
                result[r++]=nums[deque.peek()];
            }
        }
        return result;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0){
            return new int[]{};
        }
        int kth=k;

        if(nums.length<k){
            kth=nums.length;
        }
        int length=nums.length-kth+1;

        int[] result=new int[length];

        for(int i=0;i<length;i++){
            int max=Integer.MIN_VALUE;
            for(int j=i;j<nums.length&&j<=i+kth-1;j++){
                max=Math.max(max,nums[j]);
            }
            result[i]=max;
        }
        return result;
    }
}



