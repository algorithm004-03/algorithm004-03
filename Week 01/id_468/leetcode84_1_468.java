import java.util.Stack;

/**
 * @program: leetcode
 * @description: Largest Rectangle in Histogram
 * @author: 王瑞全
 * @create: 2019-10-1914:56
 **/


public class leetcode84_1_468 {
    //while的性能是for的3倍
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int maxArea=0;
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<heights.length;i++){
            while(!stack.isEmpty()&&heights[stack.peek()]<heights[i]){
                maxArea=Math.max(maxArea,heights[stack.pop()]*(i-(stack.isEmpty()?0:stack.peek()+1)));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            maxArea=Math.max(maxArea,heights[stack.pop()]*(n-(stack.isEmpty()?0:stack.peek()+1)));
        }
        return maxArea;
    }
    public int largestRectangleArea2(int[] heights) {
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int left=i,right=i;
            while(left>=0&&heights[left]>=heights[i]){
                left--;
            }
            while(right<heights.length&&heights[right]>=heights[i]){
                right++;
            }
            maxArea=Math.max(maxArea,findTheMinHeight(heights,left+1,right-1)*(right-left-1));
        }
        return maxArea;
    }
    public int largestRectangleArea1(int[] heights) {
        if(heights.length==0){
            return 0;
        }
        int maxArea=heights[0];
        for(int i=0;i<heights.length;i++){
            for(int j=i;j<heights.length;j++){
                maxArea=Math.max(maxArea,findTheMinHeight(heights,i,j)*(j-i+1));
            }
        }
        return maxArea;
    }
    public int findTheMinHeight(int[] height,int begin,int end){
        int minHeight=Integer.MAX_VALUE;
        for(int i=begin;i<=end;i++){
           minHeight=Math.min(height[i],minHeight);
        }
        return minHeight;
    }
}
