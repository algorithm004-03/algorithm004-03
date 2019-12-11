class Solution {
    public int find(int[] parent ,int i){
        if(parent[i] == -1) return i;
        return find(parent , parent[i]);
    }
    public void union (int i , int j , int[] parent){
        int xfather = find(parent , i);
        int yfather = find(parent , j);
        if(xfather != yfather) {
            parent[xfather] = yfather;
        }
    }
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent , -1);
        for(int i =0 ; i<M.length ; i++){
            for(int j = 0 ; j < M[0].length ;j++){
                if(M[i][j] == 1 && i != j) union(i,j , parent);
            }
        }
        int cnt = 0;
        for(int i =0 ; i < parent.length ; i++){
            if(parent[i] == -1 ) cnt++;
        }
        return cnt;
    }
}
