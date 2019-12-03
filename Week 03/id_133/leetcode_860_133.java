
//leetcode 题号860 柠檬水找零

//国际站看到的这个方法，思路确实很清晰，如下
/**
 * 当用户收到20美元，我们有两种方式找零
 * 1.找三张5美元
 * 2.找一张10美元和一张5美元
 * 这两种第二种是更优的，为什么呢?因为一个原则：手里要尽可能多的留5美元的零钱
 * 
 * 因此我们有以下判断：
 * 1.统计手里的5美元和10美元数量
 * 2.如果顾客给了5美元，则5美元加1
 * 3.如果顾客给了10美元，则10美元加1、5美元减1
 * 4.如果顾客给了20美元，则10美元减1、5美元减1 或 5美元减3
 * 5.同时判断下5美元的数量是否是正数，不是直接返回false
 */

public class Solution {

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {five--; ten++;}
            else if (ten > 0) {ten--; five--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int[] buyMonery = {5,5,10,10,5,20};

        Solution solution = new Solution();

        boolean result = solution.lemonadeChange(buyMonery);

        System.out.println(result);
    }
}