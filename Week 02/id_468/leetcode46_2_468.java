package week2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * @author: 王瑞全
 * @create: 2019-10-2719:05
 **/


public class leetcode46_2_468 {
    public List<List<Integer>> permute(int[] nums) {
          List<List<Integer>> list=new ArrayList<>();
          if(nums.length==0){
              return null;
          }
          solve(nums,list,new ArrayList<>(),0);
          return list;
    }
    public void solve(int[] nums,List<List<Integer>> list,List<Integer> item,int start){
        if(item.size()==nums.length){
            list.add(item);
            return;
        }
        for(int i=0;i<=item.size();i++) {
            List<Integer> myitem = new ArrayList<>(item);
            myitem.add(i,nums[start]);
            solve(nums, list, myitem, start + 1);
        }
    }

}
