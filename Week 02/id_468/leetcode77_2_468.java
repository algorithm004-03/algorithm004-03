package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: combinations
 * @author: 王瑞全
 * @create: 2019-10-2522:55
 **/


public class leetcode77_2_468 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list=new ArrayList<>();
        combine(list,new ArrayList<>(),1,n,k);
        return list;
    }
    public void combine(List<List<Integer>> conbines,List<Integer> conb,int start,int n,int k){

        if(k==0){
            conbines.add(new ArrayList<>(conb));
            return ;
        }
        for(int i=start;i<=n;i++){
            conb.add(i);
            combine(conbines,conb,i+1,n,k-1);
            conb.remove(conb.size()-1);
        }
    }
}
