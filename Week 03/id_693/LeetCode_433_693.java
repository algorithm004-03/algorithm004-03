package id_693;

import java.util.*;

/**
 * @Desc 433. 最小基因变化	https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description
 * @Auther 李雷(KyLin)
 * @Date 2019/10/29
 */
public class LeetCode_433_693 {

    //bfs
    public int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || bank == null || start.length() == 0 || end.length() == 0) {
            return 0;
        }

        LinkedList<String> banking = new LinkedList<>();
        Collections.addAll(banking, bank);
        if (!banking.contains(end)) {
            return -1;
        }
        if(start.equals(end))return 1;
        int result = minMutation(start, end, banking);

        return result == 0 ? -1 : result;
    }

    private int minMutation(String start, String end, LinkedList<String> backStrings) {
        if (start.equals(end)) {
            return 0;
        }
        int curCont = 0;
        String temp = "";

        for (int i = 0; i < start.length(); i++) {
            temp = start.substring(0, i) + start.substring(i + 1);
            curCont = getCurCont(end, backStrings, curCont, temp, i);
        }
        return curCont;

    }
    private int getCurCont(String end, LinkedList<String> backStrings, int curCont, String temp, int i) {
        for (int i1 = 0; i1 < backStrings.size(); i1++) {
            String str = backStrings.get(i1).substring(0, i) + backStrings.get(i1).substring(i + 1);
            if (temp.equals(str)) {
                String aa =backStrings.get(i1);
                backStrings.remove(i1);
                curCont = 1+ minMutation(aa, end, backStrings);
            }
        }
        return curCont;
    }

    public static void main(String[] args) {
        LeetCode_433_693.test1();
        LeetCode_433_693.test2();
        LeetCode_433_693.test3();
        LeetCode_433_693.test4();
        LeetCode_433_693.test5();//-1
    }

    public static void test1() {
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] back = {"AACCGGTA"};
        System.out.println(new LeetCode_433_693().minMutation(start, end, back));
    }

    public static void test2() {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] back = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(new LeetCode_433_693().minMutation(start, end, back));
    }

    public static void test3() {
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] back = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        System.out.println(new LeetCode_433_693().minMutation(start, end, back));
    }

    public static void test4() {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] back = {
                "AACCGATT",
                "AACCGATA",
                "AAACGATA",
                "AAACGGTA"};
        System.out.println(new LeetCode_433_693().minMutation(start, end, back));
    }

    public static void test5() {
        String start = "AACCTTGG";
        String end = "AATTCCGG";
        String[] back = {
                "AATTCCGG",
                "AACCTGGG",
                "AACCCCGG",
                "AACCTACC"};
        System.out.println(new LeetCode_433_693().minMutation(start, end, back));
    }

}