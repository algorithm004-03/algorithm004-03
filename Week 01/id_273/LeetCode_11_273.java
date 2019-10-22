//11 盛水最多的容器

//1. 暴力解法 通过遍历数组计算出每个元素组合的容器大小进行比较即可
//时间复杂度O(n^2)
//空间复杂度O(1)
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0;i<height.length-1;i++) {
            for (int j = i+1;j<height.length;j++) {
                if (Math.min(height[i],height[j])*(j-i)>max){
                    max = Math.min(height[i],height[j])*(j-i);
                }
            }
        }
        return max;
    }
}

//2. 双指针解法 通过设置左右指针 也就是夹逼的方式来获取最大容积
//先取容积横坐标最大的两个柱子，每次比较两个柱子的长度，小的柱子收缩
//时间复杂度O(n) 
//空间复杂度O(1)
public static int maxArea2(int[] height) {
	int i = 0;//左指针
	int j = height.length-1;//右指针
	int max = 0;
	while (i < j) {
		if (Math.min(height[i],height[j]) * (j-i) > max) {
			max = Math.min(height[i],height[j]) * (j-i);
		}
		if (height[i] < height[j]) {
			i++;
		}
		else {
			j--;
		}
	}
	return max;
}