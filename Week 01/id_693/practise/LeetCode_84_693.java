package id_693.practise;

import java.util.Stack;

/**
 * @Desc 84. 柱状图中最大的矩形   https://leetcode-cn.com/problems/largest-rectangle-in-histogram/submissions/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/19
 */
public class LeetCode_84_693 {
    //暴力破解 但是数据太大就会over     O(n^20
    public int largestRectangleArea2(int[] h) {
        int maxResult = 0;
        for (int i = 0; i < h.length; ++i) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < h.length; j++) {//2, 1, 5, 6, 2, 3
                //获得区间最小高度
                minHeight = Math.min(minHeight,h[j]);
                //计算
                maxResult = Math.max(maxResult,(j - i + 1) * minHeight);
            }

        }
        return maxResult;
    }

    //使用栈   0(n)
    public int largestRectangleArea(int[] h) {
        Stack<Integer> stack = new Stack<>();
        //表示没有元素没计算了，且用于值的计算
        stack.push(-1);
        int area = 0;
        // 如果压入的数据小于上一个，那么就直接 用栈中上一个下标 - 1计算
        for (int i = 0; i < h.length; i++) {
            while (stack.peek() != -1 && h[stack.peek()] >= h[i]) {
                area = Math.max(area,h[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);

        }
        //在这个时候，留下的元素值，处于伪排序中，然后把这些下标的元素 一个个的取出，假设是从当前下标开始到结尾的区间，然后计算得出结果
        while (stack.peek() != -1) {
            area = Math.max(area,h[stack.pop()] * (h.length - stack.peek() - 1));
        }
        return area;
    }

    //学习一下，看看大佬的递归思想，不是我做得
    public int largestRectangleArea3(int[] heights) {
        return findArea(heights,0,heights.length - 1);
    }

    private int findArea(int[] heights,int l,int r) {
        if (r < l) {
            return 0;
        } else if (r == l) {
            return heights[l];
        }
        int minIndex = l;
        boolean sort = true;
        for (int i = l + 1; i <= r; i++) {
            if (heights[i - 1] > heights[i]) {
                sort = false;
            }
            if (heights[i] < heights[minIndex]) {
                minIndex = i;
            }
        }
        int max = heights[minIndex] * (r - l + 1);
        if (sort) {
            for (int i = l + 1; i <= r; i++) {
                max = Math.max(max,heights[i] * (r - i + 1));
            }
            return max;
        }
        return Math.max(max,Math.max(findArea(heights,l,minIndex - 1),findArea(heights,minIndex + 1,r)));
    }

    public static void main(String[] args) {
//        //0
//        System.out.println(new LeetCode_84_693().largestRectangleArea(new int[]{0}));
//        //1
//        System.out.println(new LeetCode_84_693().largestRectangleArea(new int[]{1}));
//        //9
//        System.out.println(new LeetCode_84_693().largestRectangleArea(new int[]{9}));
        //10
        System.out.println(new LeetCode_84_693().largestRectangleArea(new int[]{2,1,5,6,2,3}));
        //2
        System.out.println(new LeetCode_84_693().largestRectangleArea(new int[]{1,1}));
        //2
        System.out.println(new LeetCode_84_693().largestRectangleArea(new int[]{1,2}));
        //9
        System.out.println(new LeetCode_84_693().largestRectangleArea(new int[]{0,9}));
        //18
        System.out.println(new LeetCode_84_693().largestRectangleArea(new int[]{9,9}));
        //19182
        System.out.println(new LeetCode_84_693().largestRectangleArea(new int[]{12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276}));

        int[] length = new int[200];
        for (int i = 0; i < length.length; i++) {
            length[i] = i;
        }
        System.out.println(new LeetCode_84_693().largestRectangleArea(length));
    }
}
