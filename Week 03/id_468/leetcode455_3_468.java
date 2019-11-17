package week3;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 分发饼干
 * @author: 王瑞全
 * @create: 2019-11-0320:40
 **/


public class leetcode455_3_468 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int index=0;
        for(int i:s){
            if(index<g.length&&g[index]<=i){ count++;index++;}

        }
        return count;
    }
}
