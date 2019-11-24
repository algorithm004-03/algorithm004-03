import java.util.Arrays;

class  RemoveDuplicates_26 {
    //思路1.暴力求解（如果不考虑O(1)的限制）：
    //(1)建立新数组，遍历老数组，每读取一个老数组都和新数组所有元素对比，不存在则存入新数组,同时count+1
    //(2)遍历数组，每一个遍历的值和前面的数对比，按照从小到大排序。重复的则放到最后面；
    //思路2.利用栈先进先出的方式，读取原数组，同样的，则不进入栈，不同样的，再给进，最后输出栈内元素(3)遍历数组，
    //问题：有思路不会写代码。
    public static int removeDuplicates1(int[] nums) {
        //LeetCode-cn官方解析
        //第一步：排除特殊情况，空数组
        if (nums.length == 0) return 0;
        // i用于记录非重复值的位置和数量，j用于遍历数组
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            //如果遍历的数不等于上一个数，则i增加，同时，让非重复值换位到非重复值这，反之跳过；
            // (注意，这种计算非重复值的前提是有序数组，非有序则不成立)
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        //因为非重复值都放在前面，所以最后一个非重复值下标+1就是非重复值数量
        return i + 1;
    }

//    public static int removeDuplicates2(int[] nums){
//        if (nums.length == 0) return 0;
//        int j = 0;
//        for (i = 0,i<nums.length,i++){
//            return i;
//        }
//
//
//
//
//    }
    public static int removeDuplicates2(int[] nums) {
        //暴力求解，参考自leetcodecn《比较笨的一种方法》,数组可以无序，能得到答案，但时间复杂度为O(n3),不符合题目n(1)的要求
        //假设全部都不是重复值，count非重复值就等于数组元素个数。如果数组为空，则返回0；
        int count = nums.length;
        if(count == 0) return 0;
        //第一层循环，用循环nums[i]遍历数组；
        for(int i = 0; i < count; i++){
            //第二层循环，后面的所有值nums[j]依次与nums[i]比较
            for(int j = i+1; j < count; j++){
                //发现有重复值，就把后面的值依次向前复制（先不管是不是重复）
                if(nums[i] == nums[j]){
                    for (int p = j ; p + 1 < count; p++){
                        nums[p]=nums[p+1];
                    }
                    //发现了重复值，非重复值的总数count要-1
                    count--;
                    //由于后面元素前移了，还需要检验这个移过来的元素是否与nums[i]重复
                    j--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[] nums = {1,1,2,3,3,2,2,1,1};
        int nums2=removeDuplicates2(nums);
        System.out.println(nums2);
        System.out.println(Arrays.toString(nums));
    }
}