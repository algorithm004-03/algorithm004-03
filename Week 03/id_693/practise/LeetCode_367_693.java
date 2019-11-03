package id_693.practise;

import org.junit.Assert;

/**
 * @Desc 367. 有效的完全平方数	https://leetcode-cn.com/problems/valid-perfect-square/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/03
 */
public class LeetCode_367_693 {
    //牛顿法，因为刚做了那个题，干脆直接带过来哈
    //注意：这样的r 做运算的时候一定要注意基本数据类型的一出问题
    public boolean isPerfectSquare1(int num) {
        long r = num;
        while (r * r > num) {
            r = (r + num / r) / 2;
        }
        return r * r == num;
    }

    //二分:其实写法也和69题一样,但是
    /*
        1、题目是为了找出num是否存在有效平方根，所以找到就返回,num说明了是正整数，所以直接1开始
        2、再其次，再判断left任何一个数的平方是否等于num 就好了。
        3、上面相对理解有点绕。可以直接用69的写法。然后只需要对结果判断是否相等就好了
     */
    public boolean isPerfectSquare2(int num) {
        long left = 1;
        long right = num >> 1;
        while (left < right) {
            long mid = left + ((right - left) >> 1);
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return left * left == num;
    }

    //看了国际站，解决上面理解有点绕的问题-
    //  -------这样left和right相等的时候也去判断一下是否等于num即可，因为判断再while内，所以right不能除以2了
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        while (left <= right) {
            long mid = left + ((right - left) >> 1);
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Assert.assertTrue(new LeetCode_367_693().isPerfectSquare(1));
        Assert.assertTrue(new LeetCode_367_693().isPerfectSquare(808201));
        Assert.assertFalse(new LeetCode_367_693().isPerfectSquare(2342));
    }
}