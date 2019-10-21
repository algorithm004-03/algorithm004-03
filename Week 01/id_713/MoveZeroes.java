package id_713;

public class MoveZeroes {

    /*
    思路:
    1. 定义一个计数器, 记录0出现的次数, 同时也将作为索引在后面使用
    2. 当前值如果不为0, 则覆盖到为0的索引, 0值计数器+1
        正常请况下, 相当于赋值给自己当前的索引, 数据也没发生变化
        在之前出现过0情况下, 当前索引的数组 会覆盖 最近的0值的索引
    3. 遍历完成后, 非0值已经覆盖0值, 且在数组前面的部分, 现在需要将后面部分都置成0, 即完毕
     */

    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroIndex] = nums[i];
                zeroIndex++;
            }

        }

        for (int i = zeroIndex; i < nums.length; i++) { // 0值的计数器 到 数组长度 即为要赋值成0的区间
            nums[i] = 0;
        }
    }
}


