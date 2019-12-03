package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * @author: 王瑞全
 * @create: 2019-10-2719:31
 **/


public class leetcode47_2_468 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
         List<List<Integer>> list=new ArrayList<>();
         if(nums==null||nums.length==0) return list;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        resolve(list,new ArrayList<>(),nums,used);
        return list;
    }
    public static void resolve(List<List<Integer>> list,List<Integer> item,int[] nums,boolean[] userd){
        if(item.size()==nums.length){
            list.add(new ArrayList<>(item));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(userd[i]) continue;
            if(i>0&&nums[i-1]==nums[i]&&!userd[i-1]) continue;
            userd[i]=true;
            item.add(nums[i]);
            resolve(list,item,nums,userd);
            userd[i]=false;
            item.remove(item.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] test={1,1,3,4};
        permuteUnique(test);
    }
}
