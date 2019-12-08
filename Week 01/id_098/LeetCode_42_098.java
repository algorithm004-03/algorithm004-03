//找中值，左右分治法
class Solution {
    public static int trap(int[] height) {

        int max = 0;
        int flagIndex = 0;

        if(height.length == 0){
            return 0;
        }

        //找出最高点
        for(int index = 0 ; index < height.length; index++){
            if(height[index] > max){
                max = height[index];
            }
        }

        int totalWater = 0;
        int sectionWater = 0;
        int flag = height[0];

        //计算最高点左边的雨水
        for(int i = 1; i < height.length; i++){

            //当在最高点左边时，这么计算
            if(height[i] == max){
                //直接得出当前的sectionWater
                totalWater = totalWater + sectionWater;
                //得到第一次找到的最高点的下标
                flagIndex = i;
                break;
            }

            //当后一位小于前一位，可以蓄水
            if(height[i] < flag){
                //开始蓄水
                sectionWater = sectionWater + (flag - height[i]);
                //否则蓄水结束，此时计算此区间内的蓄水量
            }else {
                totalWater = totalWater + sectionWater;
                //将区间蓄水量设为0
                sectionWater = 0;
                //从height[i]开始往后查询
                flag = height[i];
            }

        }

        sectionWater = 0;
        flag = height[height.length-1];
        //计算最高点右边的雨水
        for(int index = height.length-1; index >= flagIndex; index--){

            //当右边的数大于左边的数，可以存雨水
            if(height[index] < flag){
                //开始蓄水
                sectionWater = sectionWater + (flag - height[index]);
            }else {
                totalWater = totalWater + sectionWater;
                //将区间蓄水量设为0
                sectionWater = 0;
                //从height[i]开始往后查询
                flag = height[index];
            }
        }

        return totalWater;
    }
}