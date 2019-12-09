package week3;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 模拟行走机器人
 * @author: 王瑞全
 * @create: 2019-11-0321:12
 **/


public class leetcode874_3_468 {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set=new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(obs[0] + " " + obs[1]);
        }
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d=0,x=0,y=0,result=0;
        for(int c:commands){
            if(c==-1){
                d++;
                if(d==4){
                    d=0;
                }
            }else if(c==-2){
                d--;
                if(d==-1){
                    d=3;
                }
            }else{
                while(c-- >0&&!set.contains((x+dirs[d][0])+" "+(y+dirs[d][1]))){
                    x+=dirs[d][0];
                    y+=dirs[d][1];
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }
}
