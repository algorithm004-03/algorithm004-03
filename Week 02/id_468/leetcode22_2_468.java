package week2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 括号生成
 * @author: 王瑞全
 * @create: 2019-10-2420:42
 **/


public class leetcode22_2_468 {
    public List<String> generateParenthesis(int n) {
          List<String> list=new ArrayList<>();
         backtrack(list,"",0,0,n);
        return list;
    }
    public void backtrack(List<String> list,String str,int open,int close,int max){
            if(str.length()==max*2){
                list.add(str);
                return ;
            }
            if(open<max){
                backtrack(list,str+"(",open+1,close,max);
            }
            if(close<open){
                backtrack(list,str+")",open,close+1,max);
            }

    }
}
