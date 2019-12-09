package practice;

public class LeetCode_70_368 {

    /* 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    https://leetcode-cn.com/problems/climbing-stairs/ */

    public static void main(String[] args) {
        int n = 4 ;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs (int n) {
        // 找最近重复
        if (n <= 2) {
            return n;
        }
        int f3 = 0, f1 = 1, f2 = 2;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
