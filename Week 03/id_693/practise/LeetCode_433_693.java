package id_693.practise;

import java.util.*;

/**
 * @Desc 433. 最小基因变化	https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description
 * @Auther 李雷(KyLin)
 * @Date 2019/10/29
 */
public class LeetCode_433_693 {

    //dfs
    public int minMutation(String start,String end,String[] bank) {
        if (start == null || end == null || bank == null || start.length() == 0 || end.length() == 0) {
            return 0;
        }
        Set<String> backString = new HashSet<>();
        Collections.addAll(backString,bank);
        int result = dfs(start,end,backString,0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(String start,String end,Set<String> backString,int depth) {
        if (start.equals(end)) {
            return depth;
        }
        int res = Integer.MAX_VALUE;
        if (backString.isEmpty()) {
            return res;
        }
        for (String s : backString) {
            //如果有s和end相等，且只和自身只有一个变化，那么就返回变化+1;
            if (s.equals(end) && diff(s,start)) {
                return depth + 1;
                //如果有和start存在一个字母变化的，那么就进入下一步
            } else if (diff(s,start)) {
                Set<String> backString2 = new HashSet<>(backString);
                backString2.remove(s);
                res = Math.min(res,dfs(s,end,backString2,depth + 1));
            }
        }
        return res;
    }

    //验证是否是只有一个字母变化
    private boolean diff(String s,String start) {
        int res = 0;
        for (int i = 0; i < start.length(); i++) {
            if (s.charAt(i) != start.charAt(i)) {
                res++;
                if (res > 1) {
                    return false;
                }
            }
        }
        return res == 1;
    }


    //sfs+backtarck  优化空间和效率
    public int minMutation2(String start,String end,String[] bank) {
        if (start == null || end == null || bank == null || start.length() == 0 || end.length() == 0) {
            return 0;
        }
        int result = dfs2(start,end,bank,new boolean[bank.length]);
        return result > bank.length ? -1 : result;
    }

    private int dfs2(String start,String end,String[] bank,boolean[] used) {
        if (start.equals(end)) {
            return 0;
        }
        int len = bank.length;
        int res = bank.length + 1;
        for (int i = 0; i < len; i++) {
            if (!used[i] && diff(start,bank[i])) {
                used[i] = true;
                res = Math.min(res,1 + dfs2(bank[i],end,bank,used));
                used[i] = false;
            }
        }
        return res;
    }

    //test
    public static void main(String[] args) {
        LeetCode_433_693.test1();//1
        LeetCode_433_693.test2();//2
        LeetCode_433_693.test3();//3
        LeetCode_433_693.test4();//4
        LeetCode_433_693.test5();//-1
        LeetCode_433_693.test6();//4
    }

    public static void test1() {
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] back = {"AACCGGTA"};
        System.out.println(new LeetCode_433_693().minMutation2(start,end,back));
    }

    public static void test2() {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] back = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(new LeetCode_433_693().minMutation2(start,end,back));
    }

    public static void test3() {
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] back = {"AAAACCCC","AAACCCCC","AACCCCCC"};
        System.out.println(new LeetCode_433_693().minMutation2(start,end,back));
    }

    public static void test4() {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] back = {
                "AACCGATT",
                "AACCGATA",
                "AAACGATA",
                "AAACGGTA"};
        System.out.println(new LeetCode_433_693().minMutation2(start,end,back));
    }

    public static void test5() {
        String start = "AACCTTGG";
        String end = "AATTCCGG";
        String[] back = {
                "AATTCCGG",
                "AACCTGGG",
                "AACCCCGG",
                "AACCTACC"};
        System.out.println(new LeetCode_433_693().minMutation2(start,end,back));
    }

    public static void test6() {
        String start = "AAAACCCC";
        String end = "CCCCCCCC";
        String[] back = {
                "AAAACCCA",
                "AAACCCCA",
                "AACCCCCA",
                "AACCCCCC",
                "ACCCCCCC",
                "CCCCCCCC",
                "AAACCCCC",
                "AACCCCCC"};
        System.out.println(new LeetCode_433_693().minMutation2(start,end,back));
    }
}