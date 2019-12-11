package com.leetcode.week05;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tim on 2019/11/17.
 * 一只青蛙想要过河。 假定河流被等分为 x 个单元格，并且在每一个单元格内都有可能放有一石子（也有可能没有）。 青蛙可以跳上石头，但是不可以跳入水中。

 给定石子的位置列表（用单元格序号升序表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一个石子上）。 开始时， 青蛙默认已站在第一个石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格1跳至单元格2）。

 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。

 请注意：

 石子的数量 ≥ 2 且 < 1100；
 每一个石子的位置序号都是一个非负整数，且其 < 231；
 第一个石子的位置永远是0。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/frog-jump
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_403_048 {
    public boolean canCross(int[] stones) {
        if(stones[1]>1){//第一跳只能跳一格，如果stones[1]不为1，肯定为false
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < stones.length; i++){
            if(i>3 && stones[i] >= 2*stones[i-1]){//如果下一个石头位置序号为当前序号的两倍，肯定不符合
                return false;
            }
            set.add(stones[i]);
        }
        return check(stones[stones.length-1], set, 1,1);
    }

    private boolean check(int last,  Set<Integer> set, int index,int step){
        if(index == last){
            return true;
        }

        if(set.contains(index + step + 1)){
            if(check(last, set, index + step + 1, step + 1)){
                return true;
            }
        }
        if(set.contains(index + step)){
            if(check(last, set, index + step, step)){
                return true;
            }
        }

        if(step-1>0){
            if(set.contains(index + step - 1)){
                if(check(last, set, index + step - 1, step - 1)){
                    return true;
                }
            }
        }
        return false;
    }
}
