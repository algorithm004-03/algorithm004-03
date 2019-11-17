class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for(int[] ob : obstacles){
            set.add(ob[0]+" "+ob[1]);
        }
        int d=0;int x=0;int y=0;int result=0;
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        for(int c : commands){
            if(c == -1){
                d++;
                if(d==4) d=0;
            }
            else if(c == -2){
                d--;
                if(d== -1) d=3;
            }else{
                while(c-->0 && set.contains((x+dir[d][0])+" "+(y+dir[d][1]))==false){
                    x+=dir[d][0];y+=dir[d][1];
                }
            }
            result=Math.max(result,x*x+y*y);
        }
        return result;
    }
}
