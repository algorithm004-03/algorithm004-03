package id_693.practise;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Desc 120. 三角形最小路径和	https://leetcode-cn.com/problems/triangle/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/12
 */
public class LeetCode_120_693 {

    //采用自顶向下的递归方式，回超时
    public int minimumTotal1(List<List<Integer>> triangle) {
        return dp(triangle, 0, 0);
    }

    private int dp(List<List<Integer>> triangle, int index, int level) {
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(index);
        }
        int left = dp(triangle, index, level + 1);
        int right = dp(triangle, index + 1, level + 1);
        return Math.min(left, right) + triangle.get(level).get(index);
    }

    //针对以上进行优化，去除重复,使用缓存（记忆化搜索）

    public int minimumTotal2(List<List<Integer>> triangle) {
        return dp2(triangle, 0, 0, new Integer[triangle.size()][triangle.size()]);
    }

    private int dp2(List<List<Integer>> triangle, int index, int level, Integer[][] temp) {
        if (temp[level][index] != null) {
            return temp[level][index];
        }
        if (level == triangle.size() - 1) {
            temp[level][index] = triangle.get(level).get(index);
            return temp[level][index];
        }
        int left = dp2(triangle, index, level + 1, temp);
        int right = dp2(triangle, index + 1, level + 1, temp);
        temp[level][index] = (Math.min(left, right) + triangle.get(level).get(index));
        return temp[level][index];
    }

    //自低向上 dp
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int [] dp =new int [size + 1];//规律1
        for (int level = size - 1; level >= 0 ; level--) {
            for (int i = 0; i <= level; i++) {//根据规律1得出
                dp[i] = Math.min(dp[i],dp[i+1]) + triangle.get(level).get(i);
            }
        }
        return dp[size];
    }

    public static void main(String[] args) {
        Assert.assertEquals(11,new LeetCode_120_693().minimumTotal(Arrays.asList(Collections.singletonList(2),Arrays.asList(3,4),Arrays.asList(6,5,7),Arrays.asList(4,1,8,3))));
    }
}
