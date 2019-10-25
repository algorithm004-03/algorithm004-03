package id_693.practise;

import java.util.ArrayList;
import java.util.List;


/**
 * @Desc 22.括号生成 https://leetcode-cn.com/problems/generate-parentheses/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/23
 */
public class LeetCode_22_693 {

    //回溯法，
    // 有点类似动态规划，每一种可能都走一遍，直到长度满足，
    // 同时用open 和close来记录左右括号数量
    // -类似前中后序遍历
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list,"",0,0,n);
        return list;
    }

    public void generate(List<String> list,String cur,int open,int close,int max) {
        //terminator
        if (cur.length() >= max * 2) {
            //process result
            list.add(cur);
            return;
        }
        //process current logic

        //drill down
        //左括号数量需要小于max 才可以继续增加 左括号
        if (open < max) {
            generate(list,cur + "(",open + 1,close,max);
        }
        //左括号的数量大于右括号的数量说明可以继续增加 右括号
        if (open > close) {
            generate(list,cur + ")",open,close + 1,max);
        }

        //restore current status
    }

    public static void main(String[] args) {
        LeetCode_22_693 leetCode_22_693 = new LeetCode_22_693();
        System.out.println(leetCode_22_693.generateParenthesis(3));
        System.out.println(leetCode_22_693.generateParenthesis(5));


    }
}