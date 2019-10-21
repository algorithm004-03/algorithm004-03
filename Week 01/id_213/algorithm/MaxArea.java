class Solution {
//这个题目一开始用暴力解法需要两重循环,复杂度为O(n^2)
//后来经过视频观看以及思考得知可以利用先确定一个变量的情况下,
//再去改变另外一个变量。时间复杂度为O（n）
//思路：1.数组长度是确定的情况下,取两端值。获得一个最大值。
//     2. 在数组元素中取两个元素中的较小元素。并用一个指针（—引用）记录取出最大值。
//      3.遍历元素，返回指针所指位置即可。
//      这个解题的关键点是,左右两边个下标同时移动，确定大的，小的移动，最后可以得到两个相对大的值。

    public int maxArea(int[] height) {
        if(height.length == 1) return 0;
        int square = 0;
        int i = 0; int j = height.length-1;
        while(i != j){
            int min = (height[i] < height[j]) ? height[i++] : height[j--];
            if(square < (j - i + 1) *min)
            square = (j - i + 1) * min;
        }
        return square;
    }
   
}