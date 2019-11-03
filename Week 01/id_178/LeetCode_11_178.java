package org.geektime.weak01;

/**
 * Created by fukan on 2019/10/22.
 * 一维数组的变换
 */
public class LeetCode_11_178 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
//        maxArea1(height);
//        maxArea2(height);
        LeetCode_11_178 instance = new LeetCode_11_178();
        instance.maxArea3(height);
    }

    /**
     * 我的想法:
     * 枚举:left bar,right bar.(x-y)*hight_diff
     * 1.循环计算出每个矩阵的面积
     * 2.选取最大值
     * 执行用时 :
     * 539 ms, 在所有 java 提交中击败了 7.97% 的用户
     * O(n^2)
     */
    public static int maxArea1(int[] height){
        int maxArea = 0;
        int r_height = 0;
        int width = 0;

        for (int i= 0;i < height.length ;i++){
            for(int j = height.length-1;j>=0;j--){
                r_height = Math.min(height[i],height[j]);
                width = j - i;
                int area = r_height*width;
                if (area > maxArea){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }


    /**
     * 执行用时 :268 ms, 在所有 java 提交中击败了 32.34% 的用户
     * Question:为什么同样是O(n^2)的时间复杂度,maxArea2比maxArea1 运行时间少了这么多
     */
    public static int maxArea2(int[] height){
        int maxArea = 0;
        //left bar loop
        for (int i = 0;i < height.length - 1 ; i++){
            //right bar loop
            for (int j = i+1 ; j < height.length ;j++ ){
                int area = (j-i)*Math.min(height[i],height[j]);
                maxArea = Math.max(maxArea,area);
            }
        }
        return maxArea;
    }


    /**
     * 执行用时 :3 ms, 在所有 java 提交中击败了 97.07% 的用户
     * 左右收敛,中间夹逼
     */
    public static int maxArea3(int[] height){
        int maxArea = 0;
        for (int i = 0,j=height.length-1;i<j;){
            int minHeight = height[i] < height[j] ? height[i++]:height[j--];
            maxArea = Math.max(maxArea,(j- i+1)*minHeight);
        }
        return maxArea;
    }

    /**
     *
     * 官方解法
     */
    public static int maxArea4(int[] height){
        int maxArea = 0,l = 0 , r= height.length - 1;
        while (1 < r){
            maxArea = Math.max(maxArea,Math.min(height[l],height[r]) * (r-l));
            if (height[l] < height[r]){
                l++;
            }else

            r--;
        }

        return maxArea;

    }
}
