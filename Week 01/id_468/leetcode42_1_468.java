/**
 * @program: leetcode
 * @description: Trapping Rain Water
 * @author: 王瑞全
 * @create: 2019-10-2021:24
 **/


public class leetcode42_1_468 {
    public int trap(int[] height) {
        int result=0;
        int start=0;
        int end=height.length-1;
        while(start<end){
            if(height[start]<=height[end]){
                int current=height[start];
                while(height[++start]<current){
                    result+=current-height[start];
                }
            }else {
                int current=height[end];
                while(height[--end]<current){
                    result+=current-height[end];
                }
            }
        }
        return result;

    }
}
