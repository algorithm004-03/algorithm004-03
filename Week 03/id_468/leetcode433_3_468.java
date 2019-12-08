package week3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 最小基因变化
 * @author: 王瑞全
 * @create: 2019-11-0217:14
 **/


public class leetcode433_3_468 {
    public int minMutation(String start, String end, String[] bank) {
          if(start.equals(end)) return 1;
          Set<String> visited=new HashSet<>();
          Set<String> bankSet=new HashSet<>();
          for(String b:bank){
              bankSet.add(b);
          }
          Queue<Genehop> queue=new LinkedList<>();
          visited.add(start);
          queue.add(new Genehop(start,1));
          while(!queue.isEmpty()){
              Genehop next=queue.poll();
              if(next.mutation.equals(end)){
                  return next.step-1;
              }
              // why is 8
              for(int i=0;i<start.length();i++){
                  for(char c:new char[]{'A','C','G','T'}){
                      String temp=next.mutation.substring(0,i)+c+next.mutation.substring(i+1);
                      if(bankSet.contains(temp)&&!visited.contains(temp)){
                          visited.add(temp);
                          queue.add(new Genehop(temp,next.step+1));
                      }
                  }
              }
          }
          return -1;
    }
    public class Genehop{
        String mutation;
        int step;

        public Genehop(String mutation, int step) {
            this.mutation = mutation;
            this.step = step;
        }
    }
}
