/**
 * @program: leetcode
 * @description: Container With Most Water
 * @author: 王瑞全
 * @create: 2019-10-1818:49
 **/


public class leetcode11_1_468 {
    public int maxArea(int[] height){
       int left=0,right=height.length-1;
       int maxArea=0;
       while(left<right){
           maxArea=Math.max(Math.min(height[left],height[right])*(right-left),maxArea);

           if(height[left]<height[right]){
               left++;
           }else {
               right--;
           }
       }
       return maxArea;
    }
    public int maxArea1(int[] height){
        int maxArea=0;
        for(int i=0;i<height.length;i++){
            for(int j=i;j<height.length;j++){
                maxArea=Math.max(maxArea,Math.min(height[i],height[j])*(j-i));
            }
        }
        return maxArea;
    }
}
