package week3;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * @author: 王瑞全
 * @create: 2019-11-0218:22
 **/


public class leetcode22_3_468 {
    public List<String> generateParenthesis(int n) {
        List<String> array=new ArrayList<>();
        dfs(array,"",0,0,n);
        return array;
    }
    private void  dfs(List<String> list,String str,int open,int close,int max){
         if(str.length()==max*2){
             list.add(str);
             return;
         }
         if(open<max)
             dfs(list,str+"(",open+1,close,max);
         if(close<open)
             dfs(list,str+")",open,close+1,max);
    }
}
