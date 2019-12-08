package org.geektime.weak01;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 * Created by fukan on 2019/10/22.
 */
public class LeetCode_70_178 {
    public static void main(String[] args) {
        LeetCode_70_178 instance = new LeetCode_70_178();
        int a = instance.climbStairs1(1);
        System.out.print(a);

    }

    /**
     * 3 |1,1,1|1,2|2,1|
     * 4 |1,1,1,1|2,1,1|1,2,1|1,1,2|2,2|
     * 5 |1,1,1,1,1|2,1,1,1|1,1,2,1|1,1,1,2|2,2,1|
     * 推出答案是一组斐波那契数列 1 2 3 5 8...
     * 即本题答案为第N个斐波那契数是几？
     * 误区:做题只做一遍
     */
    public int climbStairs1(int n){
        if(n<=2){
            return n;
        }

        int first = 1,second = 2,third = 3;
        for (int i = 3;i<=n;i++){
                third = first + second;
                first = second;
                second = third;
        }

        return third;
    }
}
