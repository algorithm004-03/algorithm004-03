class Solution {
//  思路:(1)暴力解题法，遍历所有连续的块可以解该题。时间复杂度较高（1+2+……+n);
//      (2) 1）递归的方式，利用类似快排的方法和最大盛水量的思路，每次去找到其中最小值，记录改下表i，并分区。
//          2）分区区间 为 [p，i-1],[i+1,q]。并且记录在i位置得到的面积（i*该区间长度）。
//      可行性 ：1）我们首先选取整个数组，长度最长，再去找高度相对较高的。类似最大盛水一样。
//              2）对于面积而言要连续，于是我思考到每次取出最小的。
//              （如果不取出最小的，移动下标的话，最小的始终存在，面积会越变越小，无意义。）
//              3）并将在改下表求得的面积赋值与改下表数组。类似于快排每次找出一个数。
//                （当然对相同数值也有处理，在取最小值的时候，从左至右遍历。）
//      收获：这道题算是解决了，觉得还有优化的地方，利用递归，能够运算的量并不大，容易引起栈内存溢出。
//      关于用栈的方法还需要熟悉。
    public  int largestRectangleArea(int[] heights) {
        searchLargest(heights, 0, heights.length - 1);
        return search(heights);
    }
    private  int search(int[] heights) {
        int k = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > k)
                k = heights[i];
        }
        return k;
    }
    public  void searchLargest(int[] a, int p, int q) {
        if (p >= q) return;
        int l = searchMinest(a, p, q);
        searchLargest(a, p, l - 1);
        searchLargest(a, l + 1, q);
    }
    public  int searchMinest(int[] a, int p, int q) {
        int k = a[p];
        int j = p;
        for (int i = p; i <= q; i++) {
            if (a[i] < k) {
                k = a[i];
                j = i;
            }
        }
        a[j] = (q - p + 1) * k;
        return j;
    }
}