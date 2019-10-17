/***
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 */

public class RemoveDuplicatesFromSortedArray {


    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return  0;

        int tmp = 0;
        int current = 0;
        int index = 0;
        int item_index = 0;

        for (int i=0; i < nums.length; i++){
            current = nums[i];

            if(index >= nums.length){
                break;
            }

            // 找到最近的不相同的数字的下标
            for(int j= i+1; j<nums.length; j++){
                tmp = nums[j];
                if(tmp != current){
                    item_index = j-1;
                    break;
                }
            }

            // 设置原数组的去重后的位置的值
            nums[index] = current;

            // 将数组下标跳至最近不同的元素位置
            i = item_index;

//            System.out.println(current);
//            System.out.println(item_index);

            index++;
        }

//
//        for (int i=0; i < nums.length; i++){
//            System.out.print(nums[i] + ",");
//        }

        return index-1;
    }


    public static void main(String[]args){
        RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
        int[] array = new int[]{1,1,2};
        int i = r.removeDuplicates(array);
        System.out.println(i);
    }

}