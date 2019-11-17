package id_693;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 17. 电话号码的字母组合  https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/28
 */
public class LeetCode_17_693 {
    //回溯法，沉淀两天，终于自己求解了一次
    private char[][] elements = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        backtrack(list, digits, "", 0);
        return list;
    }

    private void backtrack(List<String> list, String digits, String temp, int first) {
        if (digits.length() == temp.length()) {
            list.add(temp);
            return;
        }
        int index = digits.charAt(first) - 50;
        for (int i = 0; i < elements[index].length; i++) {
            //看了别人的代码发现这样写法是错误的，因为Java中字符串传递下去的时候都会复制一个新的字符串，所以直接temp + elements[index][i] 即可
            temp += elements[index][i];
            backtrack(list, digits, temp, first + 1);
            temp = temp.substring(0, temp.length() - 1);
        }

    }


    //看别人的代码 进行的优化
    public List<String> letterCombinations2(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        backtrack2(list, digits, "", 0);
        return list;
    }

    private void backtrack2(List<String> list, String digits, String temp, int first) {
        if (digits.length() == temp.length()) {
            list.add(temp);
            return;
        }
        int index = digits.charAt(first) - 50;
        for (int i = 0; i < elements[index].length; i++) {
            //因为传递下去的是新的字符串，在Java中  字符串+字符串  会new String()新的字符串的。所以不用回溯
            backtrack2(list, digits, temp + elements[index][i], first + 1);
        }

    }


    //再次优化，后面复习加看别人的写法
    public List<String> letterCombinations3(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length() == 0) {
            return list;
        }
        String [] temp = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtrack3(list,temp,digits,"",0);
        return list;
    }
    private void backtrack3(List<String> list,String[] temp,String digits,String str,int index) {
        if(index == digits.length()) {
            list.add(str);
            return;
        }
        int val = (int) digits.charAt(index) - '0' - 2;
        for (int i = 0; i < temp[val].length(); i++) {
            backtrack3(list,temp,digits,str + temp[val].charAt(i),index + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_17_693().letterCombinations("89"));

    }
}